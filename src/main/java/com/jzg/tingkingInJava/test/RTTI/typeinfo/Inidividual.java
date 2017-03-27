package com.jzg.tingkingInJava.test.RTTI.typeinfo;

public class Inidividual {

	private String name;
	private static int id = 0;
	private static final int count = id++;

	public Inidividual() {
	}

	public Inidividual(String name) {
		this.name = name;
	}

	public String toString() {
		return this.getClass().getSimpleName() + name +" id is "+ count;
	}
}
