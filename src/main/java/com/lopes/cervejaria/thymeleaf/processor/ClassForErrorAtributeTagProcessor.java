package com.lopes.cervejaria.thymeleaf.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring4.util.FieldUtils;
import org.thymeleaf.templatemode.TemplateMode;

public class ClassForErrorAtributeTagProcessor extends AbstractAttributeTagProcessor {

	private static final String ATRIBUTE_NAME = "classforerror";
	private static final int PRECEDENCE = 1000;

	public ClassForErrorAtributeTagProcessor(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, null, false, ATRIBUTE_NAME, true, PRECEDENCE, true);
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName atributeName,
			String atributeValue, IElementTagStructureHandler structureHandler) {

		boolean hasError = FieldUtils.hasErrors(context, atributeValue);
		if (hasError) {
			String classesExistentes = tag.getAttributeValue("class");
			structureHandler.setAttribute("class", classesExistentes + " has-error");
		}

	}

}
