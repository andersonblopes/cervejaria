package com.lopes.cervejaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lopes.cervejaria.model.Estilo;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long> {

}
