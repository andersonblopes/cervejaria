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

import com.lopes.cervejaria.model.Estilo;
import com.lopes.cervejaria.service.EstiloService;

@Controller
public class EstiloController {

	@Autowired
	private EstiloService estiloService;

	@RequestMapping("/estilo/novo")
	public ModelAndView novo(Estilo estilo) {
		ModelAndView view = new ModelAndView("estilo/cadastro-estilo");
		return view;
	}

	@RequestMapping(value = "/estilo/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(estilo);
		}

		estiloService.salvar(estilo);
		attributes.addFlashAttribute("mensagem", "Estilo cadastrado com sucesso!");
		return new ModelAndView("redirect:/estilo/novo");
	}
}
