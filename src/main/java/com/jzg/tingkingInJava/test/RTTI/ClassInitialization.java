package com.jzg.tingkingInJava.test.RTTI;

import java.util.Random;

class Initable{
	static final int staticFinal = 47;// 编译期常量，不需要在使用的时候进行初始化类
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000); // static final 但不足以保证是编译器常量
	
	static {
		System.out.println("Initializing Initable");
	}
}

class Initiable2 {
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initiable3 {
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}

public class ClassInitialization {

	public static Random rand = new Random(47);

	public static void main(String[] args) throws ClassNotFoundException {
		Class initable = Initable.class;// 仅仅使用类名.class不会导致对类的 初始化
		System.out.println("After creating Initable ref");
		// Does not trigger initialization
		System.out.println(Initable.staticFinal); // 编译期常量，调用的时候不会导致对类的初始化，最大限度的实现了惰性加载
		// Does trigger initization
		System.out.println(Initable.staticFinal2); //不是编译器常量，调用的时候会导致对类的初始化
		// Does trigger initization
		System.out.println(Initiable2.staticNonFinal);
		Class initable3 = Class.forName("com.jzg.tingkingInJava.test.RTTI.Initiable3"); // 该方式立即对类进行初始化
		System.out.println("After creating Initiable3");
		System.out.println(Initiable3.staticNonFinal);
		
	}

}
