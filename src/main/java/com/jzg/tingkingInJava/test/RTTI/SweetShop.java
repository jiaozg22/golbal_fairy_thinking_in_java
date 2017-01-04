package com.jzg.tingkingInJava.test.RTTI;
class Candy{
	static {System.out.println("Loading Candy");}
}

class Gum{
	public static int i=0;
	public Gum(){
		i ++ ;
	}
	static {
		i ++;
		System.out.println("Loading Gum");
	}
}

class Cookie{
	static {
		System.out.println("Loading Cookie");
	}
}

public class SweetShop {
	public static void main(String[] args){
		System.out.println("inside main");
		new Candy();
		System.out.println("After creating Candy");
		System.out.println("Before creating Gum");
		try{
			//这里必须是全路径，因为是在包下面
			Class.forName("com.jzg.tingkingInJava.test.RTTI.Gum");
		}catch(ClassNotFoundException e){
			System.out.println("Class not found Gum");
		}
		new Cookie();
		System.out.println("After creating Cookie");
	}
}
