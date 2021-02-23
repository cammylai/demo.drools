package com.dhl.demo.drools.config;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsDemoConfig {

	private static final String paymentRuleFile = "payment_rules.drl";
	private static final String testFireSingleRuleFile = "single_rule.drl";

	private static final String RULES_PATH = "rules/";
	private KieServices kieServices = KieServices.Factory.get();

	@Bean
	public KieFileSystem kieFileSystem() throws IOException {

		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		Set<String> ruleFiles = new HashSet<String>();
		ruleFiles.add(paymentRuleFile);
		ruleFiles.add(testFireSingleRuleFile);
		for (String ruleFileName : ruleFiles) {
			kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH + ruleFileName, "UTF-8"));
		}
		return kieFileSystem;
	}

	@Bean
	public KieContainer kieContainer() throws IOException {
		// KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		// kieFileSystem.write(ResourceFactory.newClassPathResource(testFireSingleRuleFile));
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem());
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();

		return kieServices.newKieContainer(kieModule.getReleaseId());
	}
}
