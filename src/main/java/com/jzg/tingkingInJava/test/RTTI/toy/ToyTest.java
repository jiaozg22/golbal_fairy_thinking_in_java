package com.jzg.tingkingInJava.test.RTTI.toy;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
	// Comment out the the following default constructor
	// to see NoSuchMethodError from (*1*)
	Toy() {}
	Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries ,Waterproof,Shoots {
	FancyToy() {
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc){
		System.out.println("Class name: " + cc.getName() +
				" is interface? [" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name: " + cc.getCanonicalName());
	}
	
	public static void main(String[] args){
		Class c = null;
		try{
			c = Class.forName("com.jzg.tingkingInJava.test.RTTI.toy.FancyToy");
		}catch(ClassNotFoundException e){
			System.out.println("Can't found FuncyToy");
			System.exit(1);
		}
		printInfo(c);
		
		for(Class face : c.getInterfaces()){
			printInfo(face);
		}
		Class up = c.getSuperclass();
		
		Object obj = null;
		
		try{
			//Required default constructor
			obj = up.newInstance();//必须带有默认的构造器
		}catch(InstantiationException e){
			System.out.println("Can't instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("Can't Access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
}
