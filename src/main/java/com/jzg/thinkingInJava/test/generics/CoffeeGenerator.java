package com.jzg.thinkingInJava.test.generics;

import java.util.Iterator;
import java.util.Random;

import com.jzg.thinkingInJava.test.generics.types.Americano;
import com.jzg.thinkingInJava.test.generics.types.Breve;
import com.jzg.thinkingInJava.test.generics.types.Cappuccino;
import com.jzg.thinkingInJava.test.generics.types.Coffee;
import com.jzg.thinkingInJava.test.generics.types.Latte;
import com.jzg.thinkingInJava.test.generics.types.Mocha;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

	public Class[] types = { Latte.class, Mocha.class, Cappuccino.class,
			Breve.class, Americano.class };

	private static Random rand = new Random(47);

	public CoffeeGenerator() {
	}

	private int size = 0;

	public CoffeeGenerator(int sz) {
		size = sz;
	}

	public Coffee next() {
		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	class CoffeeIterator implements Iterator<Coffee> {
		int count = size;

		public boolean hasNext() {
			return count > 0;
		}

		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}

		public void remove() {
			// not implemented
			throw new UnsupportedOperationException();
		}
	};

	public Iterator<Coffee> iterator() {
		// FOR iteration

		return new CoffeeIterator();
	}

	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();

		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}

		for (Coffee c : new CoffeeGenerator(5)) {
			System.out.println(c);
		}
	} 
}
