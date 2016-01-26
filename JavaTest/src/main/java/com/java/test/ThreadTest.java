package com.java.test;

public class ThreadTest extends Thread {

	private int num = 0;

	public ThreadTest(int n) {
		System.out.println("쓰레드 시작 : " + this.getName());
		num = n;
	}

	public void run() {
		int i = 0;
		while (i < num) {
			System.out.print(this.getName() + ": " + i + "\n");
			i++;
		}
		this.setName("스레드 이름 바꾸기");
		System.out.println(this.getName() + ":스레드종료");
		
		System.out.println(this.getName());
		
	}

	public static void main(String[] args) {
		new ThreadTest(10).start();
	}
}
