package pl.agh.jj.jba.controller;

import java.security.Principal;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import pl.agh.jj.jba.entities.Role;
import pl.agh.jj.jba.entities.User;
import pl.agh.jj.jba.repository.RoleRepository;
import pl.agh.jj.jba.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;	

	@RequestMapping("/users")
	public String	users(Model model, Principal principal){
		model.addAttribute("uzytkownik", userService.findAll());
		model.addAttribute("thisUser", userService.findOne(principal.getName()));
		return "users";
	}
	
	@RequestMapping("/users/remove/{id}")
	public String removeUser(@PathVariable Integer id){
		userService.delete(userService.findOne(id));
		return "redirect:/users.html";
	}
	
	@RequestMapping("/users/{id}")
	public String detail(Model model,@PathVariable Integer id){
		model.addAttribute("user", userService.findOne(id));
		return "user-detail";
	}
	@RequestMapping("/users/setEnable/{id}")
	public String setEnable(Model model,@PathVariable Integer id){
		User user=userService.findOne(id);
		model.addAttribute("user", user);
		if(user.isEnabled()){
			user.setEnabled(false);
		}else{
			user.setEnabled(true);
		}
		userService.update(user);
		return "redirect:/users/"+id.toString()+".html";
	}

	@RequestMapping("/users/setrole/{id} {rolesString}")
	public String setrole(Model model, @PathVariable Integer id, @PathVariable String rolesString){
		User user=userService.findOne(id);
		model.addAttribute("user", user);
		List<Role> rolesNew=new ArrayList<Role>();
		String[] rolesNewStr=rolesString.split(";");
		
		for (int i = 0; i < rolesNewStr.length; i++) {
			rolesNew.add(roleRepository.findByName(rolesNewStr[i]));
		}
		user.setRoles(rolesNew);
		userService.update(user);
		
		return "redirect:/users/"+id.toString()+".html";
	}
	@RequestMapping("/account")
	public String account(Model model,Principal principal, @Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "account";
		}
		user=userService.findOne(principal.getName());
		userService.update(user);
		return "redirect:/account.html?success=true";
	}
	


}
