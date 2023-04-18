package com.blogspot.jpllosa.messaging;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.blogspot.jpllosa.service.Fibonacci;

@Component
public class FibonacciCompute {
	
	@Autowired
	HashMap<String, FibonacciMessage> myMap;
	
	private Fibonacci fib = new Fibonacci();
	
	@JmsListener(destination = "fibonacciCompute", containerFactory = "myFactory")
	public void receiveFibonacciMessage(FibonacciMessage fibMsg) {
		
		String result = fib.fibonacci(fibMsg.getNumbers());
		fibMsg.setResult(result);
		System.out.println(fibMsg);
		
		myMap.put(fibMsg.getId(), fibMsg);
	}

}
