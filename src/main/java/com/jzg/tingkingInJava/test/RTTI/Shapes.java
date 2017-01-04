package com.jzg.tingkingInJava.test.RTTI;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
	void draw() {
		System.out.println(this + ".draw()");
	}

	abstract public String toString();
}

class Circle extends Shape {
	@Override
	public String toString() {
		return "Circle";
	}
}

class Sequare extends Shape {
	@Override
	public String toString() {
		return "Sequare";
	}
}

class Triangle extends Shape{
	@Override
	public String toString() {
		return "Triangle";
	}
	
}

public class Shapes {
	public static void main(String[] args){
		List<Shape> shapeList = Arrays.asList(new Circle(),new Sequare(),new Triangle());
		for(Shape shape:shapeList){
			shape.draw();
		}
	}
	
}