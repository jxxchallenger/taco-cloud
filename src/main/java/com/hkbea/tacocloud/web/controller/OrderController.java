package com.hkbea.tacocloud.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkbea.tacocloud.domain.Order;

@Controller
@RequestMapping(value = {"/orders"})
public class OrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	@GetMapping(value = {"/current"})
	public String orderForm(Model model)
	{
		model.addAttribute("order", new Order());
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(Order order)
	{
		LOGGER.info("Order submitted: " + order);
		
		return "redirect:/";
	}
}
