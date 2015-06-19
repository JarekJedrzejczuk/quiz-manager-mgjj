package pl.agh.jj.jba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GrupyController {
	@RequestMapping("/grupy")
	public String grupy(){
		return "grupy";
	}

}
