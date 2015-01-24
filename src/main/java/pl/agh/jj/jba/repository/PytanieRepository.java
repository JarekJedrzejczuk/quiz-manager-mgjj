package pl.agh.jj.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agh.jj.jba.entities.Pytanie;
import pl.agh.jj.jba.entities.Quiz;

public interface PytanieRepository extends JpaRepository<Pytanie, Integer>{

	List<Pytanie> findByQuizy(Quiz quiz);
	

}
