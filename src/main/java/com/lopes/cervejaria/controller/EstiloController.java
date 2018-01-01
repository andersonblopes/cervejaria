package com.lopes.cervejaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lopes.cervejaria.model.Estilo;
import com.lopes.cervejaria.service.EstiloService;
import com.lopes.cervejaria.service.exception.EstiloCadastradoException;

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

		try {
			estiloService.salvar(estilo);

		} catch (EstiloCadastradoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
		}

		attributes.addFlashAttribute("mensagem", "Estilo cadastrado com sucesso!");
		return new ModelAndView("redirect:/estilo/novo");
	}

	@RequestMapping(value = "/estilo", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Estilo estilo, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}

		try {
			estilo = estiloService.salvar(estilo);
		} catch (EstiloCadastradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.ok(estilo);
	}
}
