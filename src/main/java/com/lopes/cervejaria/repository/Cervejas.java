package com.lopes.cervejaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lopes.cervejaria.model.Cerveja;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long> {

}
