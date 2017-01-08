package com.jzg.tingkingInJava.test.RTTI.typeinfo.creator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.jzg.tingkingInJava.test.RTTI.typeinfo.Pet;

public abstract class PetCreator {
	private Random random = new Random(47);

	// The List of the different types of Pet to create
	public abstract List<Class<? extends Pet>> types();

	public PetCreator() {
	}

	public Pet randomPet() {
		int n = random.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e2) {
			throw new RuntimeException(e2);
		}
	}

	public Pet[] createArray(int size) {
		Pet[] result = new Pet[size];
		for (int i = 0; i < size; i++) {
			result[i] = randomPet();
		}
		return result;
	}

	public ArrayList<Pet> arrayList(int size) {
		ArrayList<Pet> result = new ArrayList<Pet>();

		Collections.addAll(result, createArray(size));
		return result;
	}
}
