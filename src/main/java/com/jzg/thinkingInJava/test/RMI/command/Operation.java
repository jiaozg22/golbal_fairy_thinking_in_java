package com.jzg.thinkingInJava.test.RMI.command;

public interface Operation {
	/**
	 * 操作描述
	 */
	String description();
	
	/**
	 * 操作命令
	 */
	void command();
}
