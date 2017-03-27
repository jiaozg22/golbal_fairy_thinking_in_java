package com.jzg.thinkingInJava.test.hash;

import java.util.List;

public class TestMyHashMap {
	public static void main(String[] args) {
		MyHashMap<String, String> testMyHashMap = new MyHashMap<String, String>();
		for (int i = 0; i < 55; i++) {
			String key = ""+i;
			String value = key;
			testMyHashMap.put(key, value);
		}
		// List<String> keyList = testMyHashMap.keySet();
		// for(String key: keyList){
		// System.out.println("key:"+ key +
		// ";"+"value:"+testMyHashMap.get(key));
		// }
		for (int i = 0; i < 30; i++) {
			String key = "" + i;
			System.out.println("key:" + key + ";" + "value:"
					+ testMyHashMap.get(key));
		}

	}

}
