package com.example.ThreadLocal;

public class ThreadLocalMain {
	
	static ThreadLocal<String> threadLocalInt = new ThreadLocal<>();
	

	public static void main(String[] args) {
		ThreadLocalWithUserContext context1 = new ThreadLocalWithUserContext(1);
		ThreadLocalWithUserContext context2 = new ThreadLocalWithUserContext(2);
		new Thread(context1).start();
		new Thread(context2).start();
		
		/*Runnable runnable = () -> {
			System.out.println("thread context : " + threadLocalInt.get());
		};
		
		Thread t1 = new Thread(runnable);
		
		Thread t2 = new Thread(() -> {
			threadLocalInt.set("t1");
			System.out.println("thread context : " + threadLocalInt.get());
		});*/
		
		
	}

}
