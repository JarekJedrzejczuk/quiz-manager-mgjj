package pl.agh.jj.jba.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.agh.jj.jba.entities.Kategoria;
import pl.agh.jj.jba.entities.User;


public interface KategorieRepository extends JpaRepository<Kategoria, Integer>{

	List<Kategoria> findByUsers(List user);

	List<Kategoria> findByUsers(User user);
	
	
	@Query("delete from Kategoria k where k.kategoria_id=:id") 
	void  deleteWithoutRelations(@Param("id")String id);
}
