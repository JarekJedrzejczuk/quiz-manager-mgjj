package pl.agh.jj.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.agh.jj.jba.entities.Kategoria;
import pl.agh.jj.jba.entities.Podejscie;
import pl.agh.jj.jba.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer>{

	Quiz findByNazwa(String nazwa);

	Quiz findByKategorie(Kategoria k);

	Quiz findByPodejscie(Podejscie p);
	
	@Query("delete from Quiz q where q.quiz_id=:id") 
	void  deleteWithoutRelations(@Param("id")String id);
}
