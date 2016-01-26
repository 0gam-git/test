package com.java.test.innerclass;

public class Person {

	String name = "class.this.?.";

	void setName(String name) {
		this.name = name;
		Displayer d = new Displayer();
		d.getPersonName();
	}
	
	Displayer getDisplayer(){
		return new Displayer();
	}

	public class Displayer {
		String getPersonName() {
			return Person.this.name;
		}
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		
		System.out.println(p.getDisplayer().getPersonName());
			
	}
}
