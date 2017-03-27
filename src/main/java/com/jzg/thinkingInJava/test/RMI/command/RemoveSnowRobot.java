package com.jzg.thinkingInJava.test.RMI.command;

import java.util.Arrays;
import java.util.List;

public class RemoveSnowRobot implements Robot{
	/**
	 * 机器名字
	 */
	private String name;
	
	/**
	 * 机器型号
	 */
	private static final String model = "jiaozg牌扫雪机器人1.0";
	
	public RemoveSnowRobot(String name){
		this.name = name;
	}

	public String name() {
		return name;
	}
	
	public String model() {
		return model;
	}
	public List<Operation> operations() {
		return Arrays.asList(
				new Operation(){
					public String description() {
						return name + "破冰";
					}

					public void command() {
						System.out.println(name + " 咔嚓咔嚓冰碎了");
					}
					
				},
				new Operation(){
					public String description() {
						return name + "扫雪";
					}

					public void command() {
						System.out.println(name + " 唰唰唰雪成堆");
					}
				},
				new Operation(){
					public String description() {
						return name + "装车";
					}

					public void command() {
						System.out.println(name + " 夸夸夸一车雪");
					}
				}
				);
	}
	
	public static void main(String[] args){
		Robot.Test.test(new RemoveSnowRobot("吴雪"));
	}
}
