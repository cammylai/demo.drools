package com.dhl.demo.drools;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dhl.demo.drools.model.Cashier;
import com.dhl.demo.drools.model.Payment;
import com.dhl.demo.drools.model.SingleRule;
import com.dhl.demo.drools.model.SingleRuleRequest;
import com.dhl.demo.drools.service.PaymentService;
import com.dhl.demo.drools.service.SingleRuleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private PaymentService service;

	@Autowired
	private SingleRuleService testService;

	private SingleRuleRequest testRequest;

	private SingleRule testReponse;

	@Before
	public void setUp() {
		testRequest = new SingleRuleRequest();
		testRequest.setStatus("MARGIN");
		testReponse = new SingleRule();
	}

	@Test
	public void paymentOk() {
		Payment paymentTest = new Payment();
		paymentTest.setStatus("COMPLETED");
		paymentTest.setProvider("GRABPAY");

		Cashier cashierTest = new Cashier();

		Cashier result = service.pay(paymentTest, cashierTest);

		System.out.println("Cashier: " + cashierTest.getStatus());
		assertEquals("PAYED", result.getStatus());
	}

	@Test
	public void test_fireSingleRule_returnMargin() {
		SingleRule result = testService.testFireSingleRule(testRequest, testReponse);
		System.out.println("Margin Test: " + result.getDefaultText());
		assertEquals("MARGIN", result.getStatusName());
	}

	@Test
	public void test_fireSingleRule_returnNPC() {
		testRequest.setStatus("NPC");
		SingleRule result = testService.testFireSingleRule(testRequest, testReponse);
		System.out.println("NPC test: " + result.getDefaultText());
		assertEquals("NPC", result.getStatusName());
	}

}
