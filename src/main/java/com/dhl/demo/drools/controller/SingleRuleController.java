package com.dhl.demo.drools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhl.demo.drools.model.SingleRule;
import com.dhl.demo.drools.model.SingleRuleRequest;
import com.dhl.demo.drools.service.SingleRuleService;

@RestController
public class SingleRuleController {

	@Autowired
	SingleRuleService singleRuleService;

	@PostMapping("/singlrRule")
	public SingleRule homeInit(@RequestBody SingleRuleRequest request) {
		return singleRuleService.testFireSingleRule(request, new SingleRule());
	}

}
