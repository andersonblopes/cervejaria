package com.lopes.cervejaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstiloController {

	@RequestMapping("/estilos/novo")
	public String novo() {
		return "estilo/cadastro-estilo";
	}
}
