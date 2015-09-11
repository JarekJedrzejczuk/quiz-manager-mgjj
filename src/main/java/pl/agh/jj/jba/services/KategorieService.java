package pl.agh.jj.jba.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.jj.jba.entities.Kategoria;
import pl.agh.jj.jba.entities.Quiz;
import pl.agh.jj.jba.entities.User;
import pl.agh.jj.jba.repository.KategorieRepository;

@Service
@Transactional
public class KategorieService {

	@Autowired
	private KategorieRepository kategorieRepository;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private UserService userService;
	
	public void save(Kategoria kategoria) {
		kategorieRepository.save(kategoria);
		
	}
	public List<Kategoria> findAll() {
		return kategorieRepository.findAll();
	}
	public Kategoria findByID(Integer id){
		return kategorieRepository.getOne(id);
	}
	public Kategoria findOne(Integer id){
		return kategorieRepository.findOne(id);
	}
	public void delete(Integer id) {
		kategorieRepository.delete(id);		
	}
	public void deleteWithoutRelations(Kategoria k){
		
		if(k.getQuiz()!=null){
			Quiz q=k.getQuiz();
			q.removeKategoria(k);
			this.quizService.save(q);
			k.setQuiz(null);
		}
		
		if(k.getUsers()!=null){
			List<User> users = k.getUsers();
			for(User u:users){
				k.setUsers(null);
			}

		}
		String s=k.getKategoria_id().toString();
		kategorieRepository.delete(k.getKategoria_id());
	}
	@Transactional
	public void saveBezNiezaznaczonychUserow(Kategoria k) {
		if(k==null) return;
		List <User> users=new ArrayList<User>();
		Kategoria kTmp= null;
		

		
		if(k.getKategoria_id()!=null){
			kTmp=kategorieRepository.findOne(k.getKategoria_id());
			k.setNullFields(kTmp);
		}
		
		if((k.getQuiz()!=null)&&(k.getQuiz().getQuiz_id()!=null)){
			k.setQuiz(quizService.findByID(k.getQuiz().getQuiz_id()));
			if(kTmp!=null){
				Integer tmpKquiz_id=k.getQuiz().getQuiz_id();
				Quiz tmpQuiz=kTmp.getQuiz();
				if(tmpQuiz!=null){
					Integer tmpKtmpQuiz_id=tmpQuiz.getQuiz_id();
					if(tmpKquiz_id!=tmpKtmpQuiz_id){
						Quiz q=kTmp.getQuiz();
						q.deleteKategoria(kTmp);
						quizService.save(q);
					}
				}
			}
		}else{
			k.setQuiz(null);
		}
		
		for(User u: k.getUsers()){
				Boolean b=u.getCzyZaznaczony();
				if (b==null) b=false;
				u=userService.findOneWithAtributes(u.getId());
				if (b) {
					users.add(u);
					u.addKategoria(kTmp);
				}else{
					u.deleteKategoria(kTmp);
					u.setCzyZaznaczony(null);
				}
				userService.update(u);
		}
		
		
		k.setUsers(users);
		kategorieRepository.save(k);
		
	}

}
