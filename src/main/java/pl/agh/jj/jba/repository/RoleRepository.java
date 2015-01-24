package pl.agh.jj.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agh.jj.jba.entities.Role;
import pl.agh.jj.jba.entities.User;


public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

	List<Role> findByUsers(User user);

}
