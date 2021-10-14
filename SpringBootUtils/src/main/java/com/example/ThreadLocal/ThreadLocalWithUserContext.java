package com.example.ThreadLocal;

import java.util.UUID;

public class ThreadLocalWithUserContext implements Runnable{

	ThreadLocal<Context> userContext = new ThreadLocal<>();
	private Integer userId;

	@Override
	public void run() {
		userContext.set(new Context(UUID.randomUUID().toString()));
		System.out.println("thread context for given userId: " 
				+ userId + " is: " + userContext.get());
	}

	public ThreadLocalWithUserContext(Integer userId) {
		super();
		this.userId = userId;
	}
}
