package com.jzg.thinkingInJava.test.RMI.NullObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import com.jzg.thinkingInJava.test.RMI.command.Null;
import com.jzg.thinkingInJava.test.RMI.command.Operation;
import com.jzg.thinkingInJava.test.RMI.command.Robot;

public class NullRobotProxyHandler implements InvocationHandler {
	private String nullName;
	private Robot proxied = new NRobot();
	
	NullRobotProxyHandler(Class<? extends Robot> type){
		nullName = type.getSimpleName() + "NullRobot";
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(proxied, args);
	}
	
	private class NRobot implements Null,Robot {

		public String name() {
			return nullName;
		}

		public String model() {
			return nullName;
		}

		public List<Operation> operations() {
			return Collections.emptyList();
		}

	}

}
