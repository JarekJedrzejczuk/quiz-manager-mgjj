package pl.agh.jj.jba.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.jj.jba.entities.Odpowiedz;
import pl.agh.jj.jba.entities.Pytanie;
import pl.agh.jj.jba.repository.OdpowiedzRepository;

@Service
@Transactional
public class OdpowiedziService {

	@Autowired
	private OdpowiedzRepository odpowiedzRepository;
	
	public void save(Odpowiedz odpowiedz) {
		odpowiedzRepository.save(odpowiedz);
		
	}
	public List<Odpowiedz> findAll() {
		return odpowiedzRepository.findAll();
	}
	public void delete(Integer id) {
		odpowiedzRepository.delete(id);		
	}
	public List<Odpowiedz> findByPytania(Pytanie p){
		return odpowiedzRepository.findByPytania(p);
	}

}
