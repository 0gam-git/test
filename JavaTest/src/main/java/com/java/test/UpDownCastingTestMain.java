package com.java.test;

import java.util.Hashtable;
import java.util.Vector;

public class UpDownCastingTestMain {

	public static void main(String[] args) {
		String name = new String("홍길동");
		Integer id = new Integer(1000);
		
		Vector v = new Vector();
		v.addElement(name);
		v.addElement(id);
		
		Object obj1 = v.elementAt(0);
		Object obj2 = v.elementAt(1);
		
		String str = (String)obj1;
		Integer num = (Integer)obj2;
		System.out.println("이름:" + str+ " 번호:" + num);
		
		String str2 = (String)v.elementAt(0);
		Integer num2 = (Integer)v.elementAt(1);
		System.out.println("이름:" + str2+ " 번호:" + num2);
		
		int[] my = new int[] {1,2,3,4,5};
		int[] yo =  my.clone();
		
		
		for (int i : yo) {
			System.out.println("yo= " + i
					);
		}
		
		Hashtable hash = new Hashtable<String, String>();
		hash.put("1", "a123");
		hash.put("2", "b");
		hash.put("3", "c");
		hash.put("4", "d");
		hash.put("5", "e");
		
		Object result = hash.get("1");
		String result2 = (String) hash.get("2");
		
		System.out.println("hash[1] = " + result);
		System.out.println("hash[2] = " + result2);
		
	}
}
