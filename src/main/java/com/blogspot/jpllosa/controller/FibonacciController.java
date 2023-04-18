package com.blogspot.jpllosa.controller;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogspot.jpllosa.messaging.FibonacciMessage;
import com.blogspot.jpllosa.service.Fibonacci;

@Controller
public class FibonacciController {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	HashMap<String, FibonacciMessage> myMap;

	@GetMapping("/fib")
	public String fib(@RequestParam(name="numbers", required=true) String numbers, Model model) {
		Fibonacci fib = new Fibonacci();
		model.addAttribute("numbers", numbers);
		model.addAttribute("result", fib.fibonacci(Integer.parseInt(numbers)));
		
		return "fib";
	}
	
	@GetMapping("/jms-fib")
	public String JmsFib(@RequestParam(name="numbers", required=true) String numbers, Model model) {
		final String PENDING = "pending";
		
		UUID uuid = UUID.randomUUID();
		
		FibonacciMessage fibMsg = new FibonacciMessage(uuid.toString(),
				Integer.parseInt(numbers),
				PENDING);
		
		jmsTemplate.convertAndSend("fibonacciCompute", fibMsg);

		model.addAttribute("numbers", fibMsg.getNumbers());
		model.addAttribute("result", fibMsg.getResult());
		model.addAttribute("id", fibMsg.getId());
		
		return "jms-fib";
	}
	
	@GetMapping("/fib-updates/{id}")
	public String FibUpdates(@PathVariable String id, Model model) {
		
		FibonacciMessage fibMsg = myMap.get(id);

		if (fibMsg != null) {
			model.addAttribute("numbers", fibMsg.getNumbers());
			model.addAttribute("result", fibMsg.getResult());
		} else {
			model.addAttribute("numbers", "");
			model.addAttribute("result", "");
		}
		
		return "fib-updates";
	}
}
