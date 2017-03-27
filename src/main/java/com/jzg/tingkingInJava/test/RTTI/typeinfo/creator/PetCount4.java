package com.jzg.tingkingInJava.test.RTTI.typeinfo.creator;

import com.jzg.tingkingInJava.test.RTTI.typeinfo.Pet;


public class PetCount4 {
	public static void main(String[] args){
		TypeCounter counter = new TypeCounter(Pet.class);
		for(Pet pet:Pets.createArray(20)){
			System.out.println(pet.getClass().getSimpleName()+"");
			counter.count(pet);
			System.out.println(counter);
		}
	}

}
