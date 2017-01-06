package com.jzg.tingkingInJava.test.RTTI.generic;

public class GenericClassReferences {
	public static void main(String[] args){
		Class intClass = int.class;
		Class<Integer> genericIntClass = int.class;
		genericIntClass = Integer.class; //same thing
		intClass = double.class;
		// genericIntClass = double.class;//Illegal
		
	}

}
