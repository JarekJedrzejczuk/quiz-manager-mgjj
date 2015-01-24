package pl.agh.jj.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agh.jj.jba.entities.Podejscie;
import pl.agh.jj.jba.entities.User;


public interface PodejsciaRepository extends JpaRepository<Podejscie, Integer>{

	List<Podejscie> findByUser(User user);
	

}
