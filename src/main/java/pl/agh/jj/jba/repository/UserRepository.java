package pl.agh.jj.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import pl.agh.jj.jba.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);


}
