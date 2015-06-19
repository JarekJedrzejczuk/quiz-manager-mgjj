package pl.agh.jj.jba.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.NamingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.agh.jj.jba.entities.Role;
import pl.agh.jj.jba.entities.User;
import pl.agh.jj.jba.repository.RoleRepository;
import pl.agh.jj.jba.repository.UserRepository;


@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostConstruct
	public void init() throws InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException, SQLException{

		if(roleRepository.findByName("ROLE_ADMIN")==null){
			System.out.println("baza danych jest pusta. Inicjalizacja");
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		Role roleUczestnik = new Role();
		roleUczestnik.setName("UCZESTNIK");
		roleRepository.save(roleUczestnik);

		Role roleEgzaminator = new Role();
		roleEgzaminator.setName("EGZAMINATOR");
		roleRepository.save(roleEgzaminator);
		
		User userAdmin =new User();
		userAdmin.setName("adimn");
		userAdmin.setEnabled(true);
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		userAdmin.setPassword(bCryptPasswordEncoder.encode("admin"));
		List<Role> roles =new ArrayList<Role>();
		roles.add(roleUser);
		roles.add(roleAdmin);
		userAdmin.setRoles(roles);
		roles.clear();
		userRepository.save(userAdmin);

		User Uczestnik =new User();
		Uczestnik.setName("Uczestnik");
		Uczestnik.setEnabled(true);
		Uczestnik.setPassword("u");
		roles.add(roleUczestnik);
		Uczestnik.setRoles(roles);
		userRepository.save(Uczestnik);
		
		User Egzaminator =new User();
		Egzaminator.setName("Egzaminator");
		Egzaminator.setEnabled(true);
		Egzaminator.setPassword("EGZAMINATOR");
		roles.add(roleEgzaminator);
		Egzaminator.setRoles(roles);
		userRepository.save(Egzaminator);
		}
//		Context ctx = new InitialContext(); 
//		DataSource ds; 
//		ds = (DataSource) ctx.lookup("jdbc:mysql:localhost:3306/quizmanager");
//		Connection con = ds.getConnection("root", "Trawniki4");  
//		Statement stmt = con.createStatement(); 
//		ResultSet rs = stmt.executeQuery("select app_user.name, role.name from app_user join app_user_role on app_user.id = app_user_role.users_id join role on app_user_role.roles_id = role.id where app_user.name = ?");
//		while(rs.next()){
//			System.out.println(rs.getString("sql "+"app_user"));
//			System.out.println(rs.getString("sql "+"role_id"));
//		}
//		List<User> users= userRepository.findAll();
//		for(User u : users){
//			System.out.println(u.getName()+u.getPassword());
//		}
	}
	
}
