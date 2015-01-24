package pl.agh.jj.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agh.jj.jba.entities.Odpowiedz;
import pl.agh.jj.jba.entities.Pytanie;

public interface OdpowiedzRepository extends JpaRepository<Odpowiedz, Integer>{

	List<Odpowiedz> findByPytania(Pytanie p);
	

}
