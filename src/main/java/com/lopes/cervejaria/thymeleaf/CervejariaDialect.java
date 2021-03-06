package com.lopes.cervejaria.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import com.lopes.cervejaria.thymeleaf.processor.ClassForErrorAtributeTagProcessor;
import com.lopes.cervejaria.thymeleaf.processor.MessageElementTagProcessor;

public class CervejariaDialect extends AbstractProcessorDialect {

	public CervejariaDialect() {
		super("Lopes Cervejaria", "cervejaria", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAtributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		return processadores;
	}

}
