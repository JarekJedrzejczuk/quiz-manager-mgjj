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

import pl.agh.jj.jba.entities.Odpowiedz;
import pl.agh.jj.jba.entities.Pytanie;
import pl.agh.jj.jba.services.OdpowiedziService;
import pl.agh.jj.jba.services.PytaniaService;

@Controller
public class PytaniaController {
	@Autowired
	private PytaniaService pytaniaService;
	
	@Autowired
	private OdpowiedziService odpowiedziService;
	
	private Pytanie lastPytanie;
		
	private List<Odpowiedz> odpowiedzi=new ArrayList<Odpowiedz>();
	
	@ModelAttribute("lastPytanie")
	public Pytanie getLastPytanie() {
		return lastPytanie;
	}

	public void setLastPytanie(Pytanie lastPytanie) {
		this.lastPytanie = lastPytanie;
	}

	@ModelAttribute("odpowiedzi_lista")
	public List<Odpowiedz> getOdpowiedzi() {
		return odpowiedzi;
	}

	public void setOdpowiedzi(List<Odpowiedz> odpowiedzi) {
		this.odpowiedzi = odpowiedzi;
	}
	
	@ModelAttribute("pytanie")
	public Pytanie constructPytanie (){
		return new Pytanie();
	}

	@ModelAttribute("odpowiedz")
	public Odpowiedz constructOdpowiedz (){
		return new Odpowiedz();
	}
	
	@RequestMapping("/odpowiedzi-remove/{tresc}")
	public String doUsunOdpZtmp(Model model, @PathVariable String tresc){
		Integer id=0, id_toDel=null;
		for(id=0;id<odpowiedzi.size();id++){
			String tmp=odpowiedzi.get(id).getTresc();
			if (tmp.contains(tresc))
				id_toDel=id;
		}
		if(id_toDel!=null)
			odpowiedzi.remove((int)id_toDel);
		return "redirect:/odpowiedzi-wprowadz.html";
	}
	
	@RequestMapping("/pytania-wprowadz")
	public String	showWprowadzPytania(){
		return "pytania-wprowadz";
	}
	@RequestMapping("/odpowiedzi-wprowadz")
	public String	showWprowadzOdpowiedzi(){
		return "odpowiedzi-wprowadz";
	}
	
	@RequestMapping("/pytania-wyswietl")
	public String	showWyswietlPytania(Model model){
		model.addAttribute("pytanie", pytaniaService.findAll());
		return "pytania-wyswietl";
	}
	
	@RequestMapping(value="/odpowiedzi-wprowadz", method=RequestMethod.POST)
	public String doWprowadzOdpowiedz(@ModelAttribute("odpowiedz") Odpowiedz odpowiedz){
		if(!odpowiedzi.isEmpty()){
			odpowiedzi.add(odpowiedz);
		}else{
			odpowiedzi=new ArrayList();
			odpowiedzi.add(odpowiedz);
		}
		return "redirect:/odpowiedzi-wprowadz.html";
	}
	@RequestMapping("/odpowiedzi-wprowadz-save")
	public String doSaveOdpowiedziWith(Model model){
		lastPytanie.setOdpowiedzi(odpowiedzi);
		for (Odpowiedz odpowiedz : odpowiedzi) {
			odpowiedziService.save(odpowiedz);
		}
		pytaniaService.save(lastPytanie);
		lastPytanie=new Pytanie();
		odpowiedzi.clear();
		return "redirect:/pytania-wyswietl.html";
	}
	@RequestMapping(value="/pytania-edytuj/{id}.html")
	public String	showEdytujPytania(Model model,@PathVariable Integer id){
		model.addAttribute("pytanie", pytaniaService.findByID(id));
		return "pytania-edytuj";
	}
	@RequestMapping(value="/pytania-wprowadz", method=RequestMethod.POST)
	public String doWprowadzPytania(@ModelAttribute("pytanie") Pytanie pytanie){
		lastPytanie=new Pytanie();
		if(odpowiedzi.isEmpty()){
			odpowiedzi=new ArrayList();
		}
		pytanie.setOdpowiedzi(odpowiedzi);
		lastPytanie=pytanie;
		return "redirect:/odpowiedzi-wprowadz.html";
	}
	
	@RequestMapping("/pytania/remove/{id}")
	public String removeUser(@PathVariable Integer id){
		pytaniaService.delete(id);
		return "redirect:/pytania-wyswietl.html";
	}
	

}
