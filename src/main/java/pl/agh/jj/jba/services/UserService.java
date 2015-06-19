package pl.agh.jj.jba.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import org.springframework.stereotype.Service;

import pl.agh.jj.jba.repository.KategorieRepository;
import pl.agh.jj.jba.repository.OdpowiedzRepository;
import pl.agh.jj.jba.repository.PodejsciaRepository;
import pl.agh.jj.jba.repository.PytanieRepository;
import pl.agh.jj.jba.repository.QuizRepository;
import pl.agh.jj.jba.repository.RoleRepository;
import pl.agh.jj.jba.repository.UserRepository;
import pl.agh.jj.jba.entities.Kategoria;
import pl.agh.jj.jba.entities.Odpowiedz;
import pl.agh.jj.jba.entities.Podejscie;
import pl.agh.jj.jba.entities.Pytanie;
import pl.agh.jj.jba.entities.Quiz;
import pl.agh.jj.jba.entities.Role;
import pl.agh.jj.jba.entities.User;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PodejsciaRepository podejsciaRepository;
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private KategorieRepository kategorieRepository;
	
	@Autowired
	private PytanieRepository pytanieRepository;

	@Autowired
	private OdpowiedzRepository odpowiedzRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}
	
	@Transactional
	public User findOneWithAtributes(int id) {
		User user = findOne(id);
		List<Podejscie> podejscia=podejsciaRepository.findByUser(user);
		for(Podejscie p:podejscia){
			Quiz quiz=quizRepository.findByPodejscie(p);
			if(quiz!=null){
				List<Pytanie> pytania = pytanieRepository.findByQuizy(quiz);
				for(Pytanie pytanie: pytania){
					List<Odpowiedz> odp = odpowiedzRepository.findByPytania(pytanie);
					pytanie.setOdpowiedzi(odp);
				}
				quiz.setPytania(pytania);
			}
			p.setQuiz(quiz);
		}
		user.setPodejscia(podejscia);
		
		List<Kategoria> kategorie=kategorieRepository.findByUsers(user);
		
		for(Kategoria k: kategorie){
			Quiz quiz=quizRepository.findByKategorie(k);
			if (quiz!=null){
				List<Pytanie> pytania = pytanieRepository.findByQuizy(quiz);
				for(Pytanie pytanie: pytania){
					List<Odpowiedz> odp = odpowiedzRepository.findByPytania(pytanie);
					pytanie.setOdpowiedzi(odp);
				}
				quiz.setPytania(pytania);
			}
			k.setQuiz(quiz);
		}
		user.setKategorie(kategorie);
		
		return user;
	}

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("UCZESTNIK"));
//		roles.add(roleRepository.findByName("EGZAMINATOR"));
//		roles.add(roleRepository.findByName("ROLE_ADMIN"));
		user.setRoles(roles);

		userRepository.save(user);
	}
	public void update(User user) {
		userRepository.save(user);
	}
	public User findOneWithProperties(String name) {
		User user = userRepository.findByName(name);
		return findOneWithAtributes(user.getId());
	}

	public void delete(int id) {
		userRepository.delete(id);
	}

	public User findOne(String username) {
		return userRepository.findByName(username);
	}
	
}
