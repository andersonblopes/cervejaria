package com.lopes.cervejaria.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lopes.cervejaria.model.Cerveja;
import com.lopes.cervejaria.repository.Cervejas;

@Controller
public class CervejasController {

	private static final Logger log = LoggerFactory.getLogger(CervejasController.class);
	
	@Autowired
	private Cervejas cervejas;

	@RequestMapping("/cervejas/novo")
	public String novo(Cerveja cerveja) {
		cervejas.findAll();
		return "cerveja/cadastro-cerveja";
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}

		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		return "redirect:/cervejas/novo";
	}

}
