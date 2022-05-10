package com.shristi.training;

public class Calculator {
	
	public int sum(int a,int b) {
		System.out.println("in add method");
		return a+b;
		
	}
	public int product(int x,int y) {
		System.out.println("in product method");
		return x*y;
	}
	public int difference(int a,int b) {
		System.out.println("in difference method");
		return a-b;
	}
	public String greetUser(String name) {
		return "welcome "+name.toUpperCase();
	}
}
