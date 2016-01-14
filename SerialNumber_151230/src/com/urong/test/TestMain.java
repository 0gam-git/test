package com.urong.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.Timestamp;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class TestMain {
	static final int size = 5;
	
	private int getRandomNumber() {
		int number = new Random().nextInt(10);

		return number;
	}

	private String getRandomAlphabet() {
		char alphabet = (char) ((Math.random() * 26) + 65);
		Character c = new Character(alphabet);

		return c.toString();
	}

	private String getId() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
			return "unKnownHostName";
		}
	}

	private String getTimeStamp() {
		Calendar calendar = Calendar.getInstance();
		String timeStamp = String.valueOf(calendar.getTimeInMillis() / 1000);

		return timeStamp; 
	}

	private StringBuilder createSerialNumber() throws UnknownHostException {
		StringBuilder builder = new StringBuilder();
		String hyphen = "-";
		builder.append(getTimeStamp() + hyphen + getId() + hyphen);
		for (int i = 0; i < size; i++) {
			builder.append(getRandomAlphabet() + getRandomNumber());
		}

		return builder;
	}

	public static void main(String[] args) throws IOException {
		// UUID(Universally unique identifier)
		/*
		 * // UUID formString = UUID.fromString(randomUUID); UUID formString =
		 * UUID.fromString("9CDDCB43-1A7C-4838-B1CA-B4BB039979EC");
		 * System.out.println("formString = " +
		 * formString.toString().toUpperCase());
		 * 
		 * byte[] array = { 1, 15, 30, 127 }; UUID nameUUIDFromBytes =
		 * UUID.nameUUIDFromBytes(array); System.out.println(
		 * "nameUUIDFromBytes = " + nameUUIDFromBytes);
		 */

		String randomUUID = UUID.randomUUID().toString().toUpperCase();
		System.out.println("randomUUID = " + randomUUID);

		// --------- timeStamp + id(hostName) + randomCharacter --------
		TestMain test = new TestMain();
		System.out.println(test.createSerialNumber());
	}
}
