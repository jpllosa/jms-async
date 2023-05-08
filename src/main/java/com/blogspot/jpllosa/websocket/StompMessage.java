package com.blogspot.jpllosa.websocket;

public class StompMessage {
	String id;
	
	public StompMessage() {
	}
	
	public StompMessage(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
