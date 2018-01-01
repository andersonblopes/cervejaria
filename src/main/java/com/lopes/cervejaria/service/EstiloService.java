package com.lopes.cervejaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lopes.cervejaria.model.Estilo;
import com.lopes.cervejaria.repository.Estilos;
import com.lopes.cervejaria.service.exception.EstiloCadastradoException;

@Service
public class EstiloService {

	@Autowired
	private Estilos estilos;

	@Transactional
	public Estilo salvar(Estilo estilo) {
		Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()) {
			throw new EstiloCadastradoException("Nome de estilo já existente");
		}

		return estilos.saveAndFlush(estilo);
	}

}
