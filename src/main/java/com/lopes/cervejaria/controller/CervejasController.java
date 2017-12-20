package com.lopes.cervejaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lopes.cervejaria.model.Cerveja;
import com.lopes.cervejaria.model.enumeration.Origem;
import com.lopes.cervejaria.model.enumeration.Sabor;
import com.lopes.cervejaria.repository.Estilos;

@Controller
public class CervejasController {

	@Autowired
	private Estilos estilos;

	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView view = new ModelAndView("cerveja/cadastro-cerveja");
		view.addObject("sabores", Sabor.values());
		view.addObject("estilos", estilos.findAll());
		view.addObject("origens", Origem.values());
		return view;
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}

		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		return new ModelAndView("redirect:/cervejas/novo");
	}

}
