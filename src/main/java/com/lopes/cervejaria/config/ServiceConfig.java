package com.lopes.cervejaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lopes.cervejaria.service.CadastroCervejaService;
import com.lopes.cervejaria.storage.FotoStorage;
import com.lopes.cervejaria.storage.local.FotoStorageLocal;

@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class)
public class ServiceConfig {

	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
	}

}
