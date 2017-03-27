package com.jzg.thinkingInJava.test.generics;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
	private int n;

	public IterableFibonacci(int count) {
		n = count;
	}

	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public boolean hasNext() {
				return n > 0;
			}

			public Integer next() {
				n--;
				return IterableFibonacci.this.next();
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		IterableFibonacci iterableFibonacci = new IterableFibonacci(18);
		for (int i : iterableFibonacci) {
			System.out.println(i);
		}
	}
}
