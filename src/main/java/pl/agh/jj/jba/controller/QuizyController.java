package pl.agh.jj.jba.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;

@Controller
public class QuizyController {
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private PytaniaService pytaniaService;
	
	private List<Pytanie> pytania_lista=new ArrayList<Pytanie>();
		
	private Quiz quiz;
	
	private Map<Integer, Quiz> quizTmp = new HashMap<Integer, Quiz>();

	private Pageable curentPageable;
	
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
	
	
	@ModelAttribute("quiz")
	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
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
		Quiz quiz=new Quiz();
		List<Pytanie> pytania=pytaniaService.findAll();
		quiz.setPytania(pytania);
		model.addAttribute("quiz",quiz);
		return "quizy-wprowadz";
	}

	@RequestMapping(value="/quizy-wprowadz", method=RequestMethod.POST)
	public String doQuizyWprowadz(@ModelAttribute("quizyDoWyswietlenia") Quiz q){
		List<Pytanie> pytania = new ArrayList<Pytanie>();
		for(Pytanie p: q.getPytania()){
			if (p.getCzyUsunac()){//niezbyt szczęśliwa nazwa pola wynika z zaszłości. Najpierw zaimplementowałem usuwanie potem przyszło mi do głowy by to wykorzystać przy dodawaniu.
				pytania.add(p);
				p.setCzyUsunac(false);
			}
		}
		q.setPytania(pytania);
		quizService.saveAndUpdateRelations(q);
		return "redirect:/quizy-wyswietl.html";
	}
	 
//	@RequestMapping(value="/quizy-wprowadz", method=RequestMethod.POST)
//	public String doQuizyWprowadz(@ModelAttribute("quiz") Quiz q){
//		quiz=q;
//		pytania_lista=new ArrayList<Pytanie>();
//		return "redirect:/quizy-dodaj-pytania.html";
//	}
	@RequestMapping(value="/quiz-dodaj-pytania", method=RequestMethod.POST)
	public String	showQuizyDodajPytania(Model model,@ModelAttribute("quizyDoWyswietlenia") Quiz q){
		Quiz tmp=new Quiz();
		List<Pytanie> pytania=pytaniaService.findAll();
		pytania.removeAll(q.getPytania());
		for(Pytanie p: q.getPytania()){
//			for(Pytanie pytanie: pytania){
//				if (p.getPytanie_id()==pytanie.getPytanie_id()){
//					pytania.remove(pytanie);
//				}
//			}
		
		    Iterator<Pytanie> it=pytania.iterator();// ze względu na  java.util.ConcurrentModificationException

		    while(it.hasNext()){
		        Pytanie rootpytania=it.next();

		        if(p.getPytanie_id()== rootpytania.getPytanie_id()){

		            it.remove(); 
		        }
		    }
		}

		tmp.setPytania(pytania);
		tmp.setQuiz_id(q.getQuiz_id());
		model.addAttribute("quiz",tmp);
		quizTmp.put(q.getQuiz_id(),q);
		return "quiz-dodaj-pytania";
	}
	
	@RequestMapping(value="/quiz-dodaj-pytania/{id}", method=RequestMethod.POST)
	public String	doQuizyDodajPytania(Model model,
			@ModelAttribute("quizyDoWyswietlenia") Quiz pytaniaDoDodania,
			@PathVariable("id") Integer id){
		Quiz q=quizTmp.get(id);
		List<Pytanie> p=pytaniaService.czyUsunacWgWartosci(pytaniaDoDodania.getPytania(),true);
		p.addAll(q.getPytania());
		q.setPytania(p);
		quizService.saveAndUpdateRelations(q);
		return "redirect:/quiz-edytuj/"+q.getQuiz_id()+".html";
	}
	
	@RequestMapping("/quizy-wyswietl")
	public String	showQuizyWyswietl(Model model){
		model.addAttribute("quizyDoWyswietlenia",quizService.findAll());
		return "quizy-wyswietl";
	}
	
	@RequestMapping("/quiz-edytuj/{id}")
	public String	showQuizEdytuj(Model model, @PathVariable Integer id){
		Quiz q=quizService.findOne(id);
		model.addAttribute("quiz",q);
		model.addAttribute("dataOd", new String());//<-- bo nie umiem pobrać daty z modelu
		model.addAttribute("dataDo", new String());
		quizTmp.put(q.getQuiz_id(),q);
		return "quiz-edytuj";
	}

	
	@RequestMapping(value="/quiz-edytuj/{id}", method=RequestMethod.POST)
	public String doQuizEdytuj(@ModelAttribute("quizyDoWyswietlenia") Quiz q,
			@ModelAttribute("dataOd") String dataOd, @ModelAttribute("dataDo") String dataDo){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			q.setDostepnyDo(formatter.parse(dataDo));
			q.setDostepnyOd(formatter.parse(dataOd));
		} catch (ParseException e) {
			
		}
		quizTmp.remove(q.getQuiz_id());
		quizService.saveAndUpdateRelations(q);
		return "redirect:/quizy-wyswietl.html";
	}

//	@RequestMapping("/quizy-dodaj-pytania")
//	public String	doDodajPytania(Model model){
//		model.addAttribute("pytanie", pytaniaService.findAll());
//		if(pytania_lista==null){
//			pytania_lista = new ArrayList<Pytanie>();
//		}
//		return "quizy-dodaj-pytania";
//	}
	
	@RequestMapping("/quiz-select-pytanie/{id}")
	public String doSelectPytanie(Model model, @PathVariable Integer id) {
		Pytanie p = new Pytanie();
		//p.setPytanie_id(id); < - duuuzo szybsze
		p = pytaniaService.findOne(id);
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
	
	@RequestMapping("/quiz-remove/{id}")
	public String doQuizRemove(Model model, @PathVariable Integer id){
		Quiz q =quizService.findOne(id);
		quizService.deleteWithoutRelations(q);
		return "redirect:/quizy-wyswietl.html";
	}
	
	@RequestMapping(value="quiz-usun-pytania/{quiz_id}",method=RequestMethod.POST)
	public String showUsunPytanieZquizu(Model model,
			@PathVariable("quiz_id") Integer quiz_id, @ModelAttribute("quizyDoWyswietlenia") Quiz q){ //"quizyDoWyswietlenia" WHY?!?!? ale działa
		q=this.setQuizAndPutOnQuizTmp(q);
//		List<Pytanie> pytania = pytaniaService.findAll();
//		model.addAttribute("pytania",pytania);
//		Quiz tmp=new Quiz();
//		tmp.setPytania(pytania);
//		q.setNullFields(quizService.findByID(q.getQuiz_id()));
		model.addAttribute("quiz",q);
		return "quiz-usun-pytania";
	}
	
	@RequestMapping(value="quiz-usun-pytania",method=RequestMethod.POST)
	public String doUsunPytanieZquizu(@ModelAttribute("quizyDoWyswietlenia") Quiz q){ //"quizyDoWyswietlenia" WHY?!?!? ale działa
		quizService.saveAndUpdateRelations(q);
		return "redirect:/quiz-edytuj/"+q.getQuiz_id().toString()+".html";
	}
	
	/**
	 * @param quiz
	 * @return quiz
	 * 
	 * Ponieważ metoda ta przekształca obiekt typu Quiz wydawać się może, że powinna znaleźć się w definicji Quiz
	 * Znajduję się ona tutaj gdyż została wydzielona tylko w celu ułatwienia odkładania quizów na Mapę quizTmp.
	 * 
	 */
	public Quiz setQuizAndPutOnQuizTmp(Quiz quiz){
		Integer quizId=quiz.getQuiz_id();
		if(quizId!=null)
			quiz.setNullFields(quizTmp.remove(quizId));
		quizTmp.put(quizId, quiz);
		return quiz;
	}
	public Pageable getNextPytaniaPage(){
		Pageable p=curentPageable.next();
		if(p==null)
			p=curentPageable.first();
		curentPageable=p;
		return p;
	}
	
	@RequestMapping(value="quiz-wporwadz/pytania/next-page")
	public String quizWprowadzaniePytaniaNextPage(Model model, @PageableDefault(page = 0, value = 5) Pageable pageable){
		model.asMap();
		return "redirect:/";
	}
}
