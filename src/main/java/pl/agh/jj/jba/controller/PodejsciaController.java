package pl.agh.jj.jba.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
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
import pl.agh.jj.jba.entities.Podejscie;
import pl.agh.jj.jba.entities.PytaniaTestoweList;
import pl.agh.jj.jba.entities.Pytanie;
import pl.agh.jj.jba.entities.PytanieTestowe;
import pl.agh.jj.jba.entities.Quiz;
import pl.agh.jj.jba.entities.User;
import pl.agh.jj.jba.services.OdpowiedziService;
import pl.agh.jj.jba.services.PodejsciaService;
import pl.agh.jj.jba.services.UserService;

@Controller
public class PodejsciaController {
	@Autowired
	private UserService userService;
	
	private User user;
	
	List<Quiz> quizy;
	
	List<PytanieTestowe> pytaniaTestowe;
	
	PytaniaTestoweList pytaniaTestoweList;
	
	@Autowired
	private OdpowiedziService odpowiedziService;
	
	@Autowired
	private PodejsciaService podejsciaService;
	
	private Podejscie podejscie;
	
	@ModelAttribute("Tresc")
	public PytaniaTestoweList getPytaniaTestoweList() {
		return pytaniaTestoweList;
	}

	@RequestMapping("/podejscia")
	public String	Podejscia(Model model, Principal principal){
		user=new User();
		user.setName(principal.getName());
		user=userService.findOneWithProperties(user.getName());
		model.addAttribute("user", user);
		this.quizy=new ArrayList<Quiz>();
		for(Kategoria kategoria : user.getKategorie()){
			Quiz quizTmp=kategoria.getQuiz();
			if(quizTmp!=null)
				this.quizy.add(quizTmp);
		}
		System.out.println(this.quizy.size());
		model.addAttribute("quizy",quizy);
		return "podejscia";
	}
	
	@RequestMapping("/podejscie-wykonaj/{id}")
	public String podejsciePokaz(Model model, @PathVariable Integer id){
		Quiz quiz=quizy.get(id);
		pytaniaTestowe=new ArrayList<PytanieTestowe>();
		for(Pytanie p:quiz.getPytania()){
			PytanieTestowe pytanieTestowe=new PytanieTestowe(p);
			pytaniaTestowe.add(pytanieTestowe);
		}
		pytaniaTestoweList=new PytaniaTestoweList();
		pytaniaTestoweList.setPytaniaTestowe(pytaniaTestowe);
		model.addAttribute("Tresc", pytaniaTestoweList);
		Calendar cal = Calendar.getInstance();
		podejscie=new Podejscie();
		podejscie.setUser(user);
		podejscie.setData_wykonania(cal.getTime());
		podejscie.setQuiz(quiz);
		return "podejscie-wykonaj";
	}
	
	@RequestMapping(value="/podejscie-wykonaj/{id}",method = RequestMethod.POST)
	public String podejscieWykonaj(@ModelAttribute("Tresc") PytaniaTestoweList Tresc, BindingResult result){
		this.pytaniaTestoweList=Tresc;
		this.pytaniaTestowe=this.pytaniaTestoweList.getPytaniaTestowe();
		Integer wynik=0;
		for(PytanieTestowe p: this.pytaniaTestowe){
			wynik=wynik+p.getZdobytePunkty();
		}
		podejscie.setWynik(wynik);
		podejsciaService.save(podejscie);
		return "redirect:/podejscia.html";
	}
}
