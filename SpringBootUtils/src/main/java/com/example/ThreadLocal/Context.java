package com.example.ThreadLocal;

public class Context {
	
	private String UUID;

	public Context(String uUID) {
		super();
		UUID = uUID;
	}

	@Override
	public String toString() {
		return "Context [UUID=" + UUID + "]";
	}
	
	
}
