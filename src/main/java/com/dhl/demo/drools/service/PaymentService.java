package com.dhl.demo.drools.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhl.demo.drools.model.Cashier;
import com.dhl.demo.drools.model.Payment;

@Service
public class PaymentService {

	@Autowired
	private KieContainer kieContainer;

	public Cashier pay(Payment payment, Cashier cashier) {
		KieSession session = kieContainer.newKieSession();

		session.setGlobal("cashier", cashier);
		session.insert(payment);
		session.fireAllRules();
		session.dispose();

		return cashier;
	}
}
