package com.threeway.curso.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	//A'/' referencia que se tem depois do contexto da aplicaçãio 
	@GetMapping("/")
	public String home() {
		return "/home"; //não precisa adicionar extensão 
	}

}
