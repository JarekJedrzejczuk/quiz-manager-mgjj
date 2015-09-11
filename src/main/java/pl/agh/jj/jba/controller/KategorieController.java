package pl.agh.jj.jba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.agh.jj.jba.entities.Kategoria;
import pl.agh.jj.jba.entities.Quiz;
import pl.agh.jj.jba.entities.User;
import pl.agh.jj.jba.services.KategorieService;
import pl.agh.jj.jba.services.QuizService;
import pl.agh.jj.jba.services.UserService;

@Controller
public class KategorieController {
	@Autowired
	private KategorieService kategorieService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private QuizService quizService;
		
	private List<User> users;
	
//	private Kategoria kategoria;

	private Quiz quiz;
	
//	@RequestMapping("/kategorie")
//	public String	kategorie(){
//		return "kategorie";
//	}
	
//	@ModelAttribute("users_lista")
//	public List<User> getUsers_lista() {
//		return users;
//	}
//	
//	@ModelAttribute("user")
//	public User constructPytanie (){
//		return new User();
//	}
//	
//	@ModelAttribute("quiz")
//	public Quiz getQuiz() {
//		return quiz;
//	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

//	@ModelAttribute("kategoria")	
//	public Kategoria getKategoria() {
//		return kategoria;
//	}
//
//	public void setKategoria(Kategoria kategoria) {
//		this.kategoria = kategoria;
//	}
	@ModelAttribute("kategoriaTmp")
	public Kategoria constructKategoriaTmp (){
		return new Kategoria();
	}

	@RequestMapping("/kategorie-deselect-user/{id}")
	public String doUsunOdpZtmp(Model model, @PathVariable Integer id){
		for(int i = 0;i<users.size();i++){
			Integer tmp=users.get(i).getId();
			if (id==tmp){
				break;
			}
		}
		return "redirect:/kategorie-dodaj-uzytkownika.html";
	}
	
	@RequestMapping("/kategorie/kategoria-wprowadz-edytuj/{id}")
	public String	showKategorieWprowadz(Model model, @PathVariable("id") Integer id){
		Kategoria k=new Kategoria();
		if (id>=0){
			k=kategorieService.findOne(id);
			
		}
		List<Quiz> quizyWszystkie=quizService.findAll();
		quizyWszystkie.remove(k.getQuiz());
 		model.addAttribute("quizyWszystkie", quizyWszystkie);
 		
 		List<User> users=userService.findAll();
 		List<User> newUsers= new ArrayList<User>();
 		for(User u: users){
 			if(k.containsUserByUserId(u.getId())){
 				u.setCzyZaznaczony(true);
 			}
 			newUsers.add(u);
 		}
 		k.setUsers(newUsers);
		model.addAttribute("kategoria",k);
		return "kategoria-wprowadz-edytuj";
	}
	
	@RequestMapping(value="/kategorie/kategoria-wprowadz-edytuj/{id}",method=RequestMethod.POST)
	public String doKategorieWprowadz(@ModelAttribute("kategoria") Kategoria k, BindingResult result){
		if((k.getQuiz().getQuiz_id()!=null)||(k.getUsers()!=null))
		kategorieService.saveBezNiezaznaczonychUserow(k);
		return "redirect:/kategorie-wyswietl.html";
	}
	
	@RequestMapping("/kategorie-wyswietl")
	public String	showKategorieWyswietl(Model model){
		model.addAttribute("kategorieDoWyswietlenia",kategorieService.findAll());
		return "kategorie-wyswietl";
	}
	
//	@RequestMapping("/kategorie-wprowadz")
//	public String doKategorieWprowadz(){
//		this.kategoria=new Kategoria();
//		users=new ArrayList<User>();
//		quiz=new Quiz();
//		return "redirect:/kategorie-dodaj-uzytkownika.html";
//	}
	
	@RequestMapping(value="/kategorie-dodaj-uzytkownika")
	public String	doDodajUserow(Model model){
		model.addAttribute("uzytkownicy", userService.findAll());
		model.addAttribute("quizy", quizService.findAll());
		return "kategorie-dodaj-uzytkownika";
	}
	
	@RequestMapping("/kategoria-select-uzytkownik/{id}")
	public String doSelectUser(Model model, @PathVariable Integer id) {
		User u = new User();
		u.setId(id); //< - duuuzo szybsze
		//p=pytaniaService.findOne(id);
		if(users.isEmpty()){
			System.out.println(users.isEmpty());
			users=new ArrayList<User>();
		}
		users.add(u);
		System.out.println(users.size());
		return "redirect:/kategorie-dodaj-uzytkownika.html";
	}
	
	@RequestMapping("/kategoria-select-quiz/{id}")
	public String doSelectQuiz(Model model, @PathVariable Integer id) {
		Quiz q = new Quiz();
		q.setQuiz_id(id); //< - duuuzo szybsze	
		if(quiz==null){
			quiz=new Quiz();
		}
		quiz=q;
		return "redirect:/kategorie-dodaj-uzytkownika.html";
	}
	
//	@RequestMapping("/kategoria-save")
//	public String doQuizSave(){
//		if(kategoria!=null){
//			kategoria.setUsers(users);
//			kategoria.setQuiz(quiz);
//			kategorieService.save(kategoria);
//			users.clear();
//			quiz=new Quiz();
//		}
//		return "redirect:/kategorie-wyswietl.html";
//	}
	@RequestMapping("/kategoria-remove/{id}")
	public String kategoriaRemove(@PathVariable("id") Integer id){
		kategorieService.deleteWithoutRelations(kategorieService.findOne(id));
		return "redirect:/kategorie-wyswietl.html";
	}
	
}
