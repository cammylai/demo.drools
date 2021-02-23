package com.dhl.demo.drools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhl.demo.drools.model.Cashier;
import com.dhl.demo.drools.model.Payment;
import com.dhl.demo.drools.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@PostMapping("/payment")
	public Cashier homeInit(@RequestBody Payment payment) {
		return paymentService.pay(payment, new Cashier());
	}

	@GetMapping("/try")
	public String getTestResult() {
		return "path error";
	}
}
