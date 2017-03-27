package com.jzg.tingkingInJava.test.RTTI.typeinfo.creator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.jzg.tingkingInJava.test.RTTI.typeinfo.Cat;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Cymric;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Dog;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.EgyptianMau;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Hamster;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Manx;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Mouse;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Mutt;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Pet;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Pug;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Rat;
import com.jzg.tingkingInJava.test.RTTI.typeinfo.Rodent;

public class LiteralPetCreator extends PetCreator {
	@SuppressWarnings("unchecked")
	public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(Pet.class,Dog.class,Cat.class,Rodent.class,Mutt.class,Pug.class,EgyptianMau.class,Manx.class,Cymric.class,Rat.class,Mouse.class,Hamster.class));
	
	//Types for random creation
	private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.indexOf(Mutt.class)+1);
	
	@Override
	public List<Class<? extends Pet>> types() {
		return types;
	}

	public static void main(String[] args){
		System.out.println(types);
	}
}
