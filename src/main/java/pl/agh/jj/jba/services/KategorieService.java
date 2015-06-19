package pl.agh.jj.jba.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.jj.jba.entities.Kategoria;
import pl.agh.jj.jba.repository.KategorieRepository;

@Service
@Transactional
public class KategorieService {

	@Autowired
	private KategorieRepository kategorieRepository;
	
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
	

}
