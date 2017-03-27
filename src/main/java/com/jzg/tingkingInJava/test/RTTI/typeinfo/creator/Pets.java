package com.jzg.tingkingInJava.test.RTTI.typeinfo.creator;

import java.util.ArrayList;

import com.jzg.tingkingInJava.test.RTTI.typeinfo.Pet;

public class Pets {
	public static final PetCreator creator = new LiteralPetCreator();
	public static Pet randomPet() {
		return creator.randomPet();
	}
	
	public static Pet[] createArray(int size){
		return creator.createArray(size);
	}
	
	public static ArrayList<Pet> arrayList(int size){
		return creator.arrayList(size);	
	}
}