package pl.agh.jj.jba.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pl.agh.jj.jba.entities.Pytanie;
import pl.agh.jj.jba.entities.Quiz;
import pl.agh.jj.jba.repository.PytanieRepository;

@Service
@Transactional
public class PytaniaService {

	@Autowired
	private PytanieRepository pytanieRepository;
	
	public void save(Pytanie pytanie) {
		pytanieRepository.save(pytanie);
		
	}
	public List<Pytanie> findAll() {
		return pytanieRepository.findAll();
	}
	public Pytanie findByID(Integer id){
		return pytanieRepository.getOne(id);
	}
	public Pytanie findOne(Integer id){
		return pytanieRepository.findOne(id);
	}
	public void delete(Integer id) {
		pytanieRepository.delete(id);		
	}
	public List<Pytanie> findByQuizy(Quiz quiz){
		return pytanieRepository.findByQuizy(quiz);
	}
	public List<Pytanie> findAll(Pageable next) {
		return pytanieRepository.findAll(next).getContent();
	}
	public List<Pytanie> czyUsunacWgWartosci (List<Pytanie> pytaniaDoSprawdzenia, Boolean wartosc){
		List<Pytanie> pytania=new ArrayList<Pytanie>();
		for(Pytanie p: pytaniaDoSprawdzenia){
			if (p.getCzyUsunac()==wartosc){
				p.setCzyUsunac(false);
				pytania.add(p);
			}
		}
		return pytania;
	}

}
