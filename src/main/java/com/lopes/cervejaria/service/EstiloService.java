package com.lopes.cervejaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lopes.cervejaria.model.Estilo;
import com.lopes.cervejaria.repository.Estilos;

@Service
public class EstiloService {

	@Autowired
	private Estilos estilos;

	@Transactional
	public void salvar(Estilo estilo) {
		estilos.save(estilo);
	}

}
