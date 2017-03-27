package com.jzg.thinkingInJava.test.generics.types;

public class Coffee {
	
	private static long counter = 0;
	
	private final long id = counter++;
	
	public String toString(){
		return getClass().getSimpleName() + " " + id;
	}
}
