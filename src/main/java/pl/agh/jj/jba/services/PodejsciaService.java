package pl.agh.jj.jba.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.jj.jba.entities.Podejscie;
import pl.agh.jj.jba.entities.User;
import pl.agh.jj.jba.repository.PodejsciaRepository;

@Service
@Transactional
public class PodejsciaService {

	@Autowired
	private PodejsciaRepository podejsciaRepository;
	
	public void save(Podejscie podejscie) {
		podejsciaRepository.save(podejscie);
		
	}
	public List<Podejscie> findAll() {
		return podejsciaRepository.findAll();
	}
	public Podejscie findByID(Integer id){
		return podejsciaRepository.getOne(id);
	}
	public Podejscie findOne(Integer id){
		return podejsciaRepository.findOne(id);
	}
	public void delete(Integer id) {
		podejsciaRepository.delete(id);		
	}
	
	public List<Podejscie> findByUser(User user){
		return podejsciaRepository.findByUser(user);
	}

}
