package com.java.test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import org.omg.CORBA_2_3.portable.InputStream;

public class JavaInputOutputTestMain {

	// public static void main(String args[]) throws IOException {
	// System.out.println("아무 글이나 입력하시고 Enter를 쳐주세요");
	// System.out.println(" 'S'를 입력하면 프로그램이 종료된다.");
	// int ch;
	// InputStream in = (InputStream)System.in;
	// OutputStream out = System.out;
	// while ((ch = in.read()) != -1) {
	// if (ch == 'S') {
	// byte[] arr = new byte[4];
	// arr[0] = 83;
	// arr[1] = 84;
	// arr[2] = 79;
	// arr[3] = 80;
	// out.write(arr);
	// out.flush();
	// out.close();
	// in.close();
	// System.exit(-1);
	// }
	// System.out.println("Char: " + (char) ch + ", Available: " +
	// in.available());
	// }
	// }

	public static void main(String[] args) {
		File f1 = new File("FileTest.txt");
		System.out.println(" f1.getPath(): " + f1.getPath());
		System.out.println(" f1.getAbsolutePath(): " + f1.getAbsolutePath());
		System.out.println(" f1.getName(): " + f1.getName());
		System.out.println(" f1.getPath(): " + f1.getPath());
		System.out.println(" f1.toString(): " + f1.toString());
		try {
			System.out.println(" f1.toURL(): " + f1.toURL());
		} catch (java.net.MalformedURLException e) {
			System.out.println(" f1.toURL(): " + e);
		}
		System.out.println(" f1.canRead(): " + f1.canRead());
		System.out.println(" f1.canWrite(): " + f1.canWrite());
		System.out.println(" f1.isAbsolute(): " + f1.isAbsolute());
		System.out.println(" f1.isDirectory(): " + f1.isDirectory());
		System.out.println(" f1.isHidden(): " + f1.isHidden());
		System.out.println(" f1.lastModified(): " + f1.lastModified());
		System.out.println(" f1.length(): " + f1.length());
		System.out.println(" f1.exists(): " + f1.exists());
	}
}
