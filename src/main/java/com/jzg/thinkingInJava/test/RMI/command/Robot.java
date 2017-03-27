package com.jzg.thinkingInJava.test.RMI.command;

import java.util.List;

public interface Robot {
	/**
	 * 机器名
	 */
	String name();
	
	/**
	 * 机器模块
	 */
	String model();

	List<Operation> operations();	
	
	class Test{
		public static void test(Robot robot){
			if(robot instanceof Null){
				System.out.println("[Robot is Null]");
			}
			System.out.println("Robot is name:" + robot.name());
			System.out.println("Robot is model:" + robot.model());
			for(Operation operation : robot.operations()){
				System.out.println(operation.description());
				operation.command();
			}
		}
	}
}
