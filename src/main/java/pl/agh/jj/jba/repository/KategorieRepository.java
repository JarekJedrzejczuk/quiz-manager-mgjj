package pl.agh.jj.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agh.jj.jba.entities.Kategoria;
import pl.agh.jj.jba.entities.User;


public interface KategorieRepository extends JpaRepository<Kategoria, Integer>{

	List<Kategoria> findByUsers(List user);

	List<Kategoria> findByUsers(User user);
	

}
