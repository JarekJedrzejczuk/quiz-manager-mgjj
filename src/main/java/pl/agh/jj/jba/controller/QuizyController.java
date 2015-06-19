package pl.agh.jj.jba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.agh.jj.jba.entities.Pytanie;
import pl.agh.jj.jba.entities.Quiz;
import pl.agh.jj.jba.services.PytaniaService;
import pl.agh.jj.jba.services.QuizService;

@Controller
public class QuizyController {
	@Autowired
	private QuizService quizService;
	
	private List<Pytanie> pytania_lista=new ArrayList<Pytanie>();
	
	@Autowired
	private PytaniaService pytaniaService;
	
	@ModelAttribute("pytania_lista")
	public List<Pytanie> getPytania_lista() {
		return pytania_lista;
	}
	
	@ModelAttribute("pytanie")
	public Pytanie constructPytanie (){
		return new Pytanie();
	}
	@ModelAttribute("quizTmp")
	public Quiz constructQuizTmp (){
		return new Quiz();
	}
	
	private Quiz quiz;
	
	@ModelAttribute("quiz")
	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	
	@RequestMapping("/quiz-deselect-pytanie/{id}")
	public String doUsunOdpZtmp(Model model, @PathVariable Integer id){
		for(int i = 0;i<pytania_lista.size();i++){
			Integer tmp=pytania_lista.get(i).getPytanie_id();
			System.out.println(tmp);
			if (i==tmp){
				System.out.println(pytania_lista.remove(i));
				break;
			}
		}
		return "redirect:/quizy-dodaj-pytania.html";
	}
	
	public void setPytania_lista(List<Pytanie> pytania_lista) {
		this.pytania_lista = pytania_lista;
	}
	
	@RequestMapping("/quizy")
	public String	showQuizy(){
		return "quizy";
	}
	
	@RequestMapping("/quizy-wprowadz")
	public String	showQuizyWprowadz(Model model){
		return "quizy-wprowadz";
	}
	
	@RequestMapping("/quizy-wyswietl")
	public String	showQuizyWyswietl(Model model){
		model.addAttribute("quizyDoWyswietlenia",quizService.findAll());
		return "quizy-wyswietl";
	}
	
	@RequestMapping(value="/quizy-wprowadz", method=RequestMethod.POST)
	public String doQuizyWprowadz(@ModelAttribute("quizTmp") Quiz q){
		quiz=q;
		pytania_lista=new ArrayList<Pytanie>();
		return "redirect:/quizy-dodaj-pytania.html";
	}
	
//	@RequestMapping("/quizy-dodaj-pytania")
//	public String	showDodajPytania(Model model){
//		return "quizy-dodaj-pytania";
//	}
	@RequestMapping("/quizy-dodaj-pytania")
	public String	doDodajPytania(Model model){
		model.addAttribute("pytanie", pytaniaService.findAll());
		if(pytania_lista==null){
			pytania_lista=new ArrayList();
		}
		
		return "quizy-dodaj-pytania";
	}
	
	@RequestMapping("/quiz-select-pytanie/{id}")
	public String doSelectPytanie(Model model, @PathVariable Integer id) {
		Pytanie p = new Pytanie();
		//p.setPytanie_id(id); < - duuuzo szybsze
		p=pytaniaService.findOne(id);
		if(pytania_lista.isEmpty()){
			pytania_lista=new ArrayList<Pytanie>();
		}
		pytania_lista.add(p);
		return "redirect:/quizy-dodaj-pytania.html";
	}
	
	@RequestMapping("/quiz-save")
	public String doQuizSave(){
		if(quiz.getNazwa()!=null){
			quiz.setPytania(pytania_lista);
			quizService.save(quiz);
			pytania_lista.clear();
			quiz=new Quiz();
		}
		return "redirect:/quizy-wyswietl.html";
	}
}
