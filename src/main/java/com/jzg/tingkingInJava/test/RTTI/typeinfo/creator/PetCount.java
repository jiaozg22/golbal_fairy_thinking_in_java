package com.jzg.tingkingInJava.test.RTTI.typeinfo.creator;

import java.util.HashMap;

import com.jzg.tingkingInJava.test.RTTI.typeinfo.Cat;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Dog;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Hamster;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Manx;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Mouse;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Mutt;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Pet;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Pug;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Rat;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Rodent;

public class PetCount {
	// 静态内部类
	static class PetCounter extends HashMap<String, Integer> {
		public void count(String type) {
			Integer quantity = get(type);
			if (quantity == null) {
				put(type, 1);
			} else {
				put(type,quantity+1);
			}
		}
	}

	public static void countPets(PetCreator creator){
		PetCounter counter = new PetCounter();
		for(Pet pet : creator.createArray(20)){
			//List each individual pet:
			System.out.print(pet.getClass().getSimpleName() + " ");
			if(pet instanceof Pet){
				counter.count("Pet");
			}if(pet instanceof Dog){
				counter.count("Dog");
			}if(pet instanceof Mutt){
				counter.count("Mutt");
			}if(pet instanceof Pug){
				counter.count("Pug");
			}if(pet instanceof Cat){
				counter.count("Cat");
			}if(pet instanceof Manx){
				counter.count("EgyptianMau");
			}if(pet instanceof Manx){
				counter.count("Manx");
			}if(pet instanceof Manx){
				counter.count("Cymric");
			}if(pet instanceof Rodent){
				counter.count("Rodent");
			}if(pet instanceof Rat){
				counter.count("Rat");
			}if(pet instanceof Mouse){
				counter.count("Mouse");
			}if(pet instanceof Hamster){
				counter.count("Hamster");
			}
		}
		
		//show the counts
		System.out.println();
		System.out.println(counter);
	}
	
	public static void main(String[] args){
		countPets(new ForNameCreator());
	}
}
