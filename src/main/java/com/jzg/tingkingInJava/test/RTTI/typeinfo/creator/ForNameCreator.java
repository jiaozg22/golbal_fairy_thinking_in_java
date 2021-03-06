package com.jzg.tingkingInJava.test.RTTI.typeinfo.creator;

import java.util.ArrayList;
import java.util.List;

import com.jzg.tingkingInJava.test.RTTI.typeinfo.Pet;

public class ForNameCreator extends PetCreator {

	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

	private static String[] typeNames = {
			"com.jzg.tingkingInJava.test.RTTI.typeinfo.Mutt",
			"com.jzg.tingkingInJava.test.RTTI.typeinfo.Pug",
			"com.jzg.tingkingInJava.test.RTTI.typeinfo.EgyptianMau",
			"com.jzg.tingkingInJava.test.RTTI.typeinfo.Manx",
			"com.jzg.tingkingInJava.test.RTTI.typeinfo.Cymric",
			"com.jzg.tingkingInJava.test.RTTI.typeinfo.Rat",
			"com.jzg.tingkingInJava.test.RTTI.typeinfo.Mouse",
			"com.jzg.tingkingInJava.test.RTTI.typeinfo.Hamster" };

	@SuppressWarnings("unchecked")
	private static void loader() {
		try {
			for (String name : typeNames) {
				types.add((Class<? extends Pet>) Class.forName(name));
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	static {
		loader();
	}

	public List<Class<? extends Pet>> types() {
		return types;
	}
}
