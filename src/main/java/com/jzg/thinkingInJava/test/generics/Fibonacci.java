package com.jzg.thinkingInJava.test.generics;

public class Fibonacci implements Generator<Integer> {

	private int count;

	// public Fibonacci(int index) throws Exception {
	// if (this.count < 0) {
	// throw new Exception("请输入正确初始化参数");
	// }
	// this.count = index;
	// this.fibonacciArray = new ArrayList<Integer>();
	// }

	private int allCount = 0;

	public int getFibonacci(int index) {
		allCount++;
		if (index < 2) {
			return 1;
		}
		return getFibonacci(index - 2) + getFibonacci(index - 1);
	}

	public Integer next() {
		return getFibonacci(count++);
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public static void main(String[] args) {
		//修改master分支
		Fibonacci fibonacci = new Fibonacci();
		System.out.println("18的菲波那切数列:" + fibonacci.getFibonacci(18) + "."
				+ "getFibonacci方法被调用过的次数" + fibonacci.allCount);
		fibonacci.allCount = 0;
		for (int i = 0; i < 18; i++) {
			System.out.print(fibonacci.next() + " ");
		}
		System.out.println("18的菲波那切数列循环之后:"
				+ "getFibonacci方法被调用过的次数" + fibonacci.allCount);
		
	}
}
