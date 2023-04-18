package com.blogspot.jpllosa.messaging;

public class FibonacciMessage {
	String id;
	Integer numbers;
	String result;
	
	public FibonacciMessage() {
	}
	
	public FibonacciMessage(String id, Integer numbers, String result) {
		this.id = id;
		this.numbers = numbers;
		this.result = result;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getNumbers() {
		return numbers;
	}
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "FibonacciMessage [id=" + id + ", numbers=" + numbers + ", result=" + result + "]";
	}
}
