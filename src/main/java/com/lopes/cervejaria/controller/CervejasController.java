package com.lopes.cervejaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lopes.cervejaria.model.Cerveja;

@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/cadastro-cerveja";
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(Cerveja cerveja) {
		System.out.println(">>> Cerveja: " + cerveja.getNome() + " - " + cerveja.getSku());
		return "cerveja/cadastro-cerveja";
	}

}
