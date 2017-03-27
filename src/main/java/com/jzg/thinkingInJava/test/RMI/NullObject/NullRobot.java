package com.jzg.thinkingInJava.test.RMI.NullObject;

import java.lang.reflect.Proxy;

import com.jzg.thinkingInJava.test.RMI.command.Null;
import com.jzg.thinkingInJava.test.RMI.command.RemoveSnowRobot;
import com.jzg.thinkingInJava.test.RMI.command.Robot;

public class NullRobot {
	public static Robot newNullRobot(Class <? extends Robot> type){
		return (Robot)Proxy.newProxyInstance(NullRobot.class.getClassLoader(), new Class[]{Null.class,Robot.class},new NullRobotProxyHandler(type));
	}
	
	public static void main(String[] args){
		Robot[] robots = {
				new RemoveSnowRobot("吴雪代理"),
				newNullRobot(RemoveSnowRobot.class)
		};
		for(Robot robot : robots){
			Robot.Test.test(robot);
		}
	}
}

