package pl.agh.jj.jba.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.jj.jba.entities.Kategoria;
import pl.agh.jj.jba.entities.Podejscie;
import pl.agh.jj.jba.entities.Pytanie;
import pl.agh.jj.jba.entities.Quiz;
import pl.agh.jj.jba.repository.QuizRepository;

@Service
@Transactional
public class QuizService {

	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private KategorieService kategorieService;
	
	@Autowired
	private PodejsciaService podejsciaService;
	
	@Autowired
	private PytaniaService pytaniaService;
	
	public void save(Quiz quiz) {
		quizRepository.save(quiz);	
		
	}
	
	@Transactional
	public void saveAndUpdateRelations(Quiz newQuiz) {
		List<Quiz> quizyTmp;
		List<Pytanie> pytania=new ArrayList<Pytanie>();
		for(Pytanie p: newQuiz.getPytania()){
			quizyTmp = p.getQuizy();
			if (p.getCzyUsunac()){
				if(quizyTmp!=null){
					if(!quizyTmp.contains(p)){
						quizyTmp.add(newQuiz);
					}
					p.setQuizy(quizyTmp);
					pytaniaService.save(p);
				}
			} else{
				if (quizyTmp==null){
					quizyTmp=new ArrayList<Quiz>();
				}
				quizyTmp.add(newQuiz);
				pytania.add(p);
			}
		}
		newQuiz.setPytania(null);
		quizRepository.save(newQuiz);
		newQuiz.setPytania(pytania);
		quizRepository.save(newQuiz);	
		
	}

	public List<Quiz> findAll() {
		return quizRepository.findAll();
	}
	public Quiz findByID(Integer id){
		return quizRepository.getOne(id);
	}
	public Quiz findOne(Integer id){
		return quizRepository.findOne(id);
	}
	public void delete(Integer id) {
		quizRepository.delete(id);		
	}
	public void deleteWithoutRelations(Quiz q){
		if (q.getKategorie()!=null){
			for(Kategoria k : q.getKategorie()){
				k.setQuiz(null);
				kategorieService.save(k);
			}}
			if(q.getPodejscie()!=null){
			for(Podejscie p : q.getPodejscie()){
				p.setQuiz(null);
				podejsciaService.save(p);
			}}
			if(q.getPytania()!=null){
				for(Pytanie p : q.getPytania()){
					List<Quiz> quizy = p.getQuizy();
					quizy.remove(q);
					p.setQuizy(quizy);
					pytaniaService.save(p);
				}}
			q.setKategorie(null);
			q.setPodejscie(null);
			q.setPytania(null);
			String s=q.getQuiz_id().toString();
			quizRepository.delete(q.getQuiz_id());
	}
	
}
