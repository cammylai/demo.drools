package com.dhl.demo.drools.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhl.demo.drools.model.SingleRule;
import com.dhl.demo.drools.model.SingleRuleRequest;

@Service
public class SingleRuleService {

	@Autowired
	private KieContainer kieContainer;

	public SingleRule testFireSingleRule(SingleRuleRequest request, SingleRule response) {
		KieSession session = kieContainer.newKieSession();

		session.setGlobal("response", response);
		session.insert(request);
		session.fireAllRules();
		session.dispose();

		return response;
	}
}
