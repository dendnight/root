package com.dendnight.test;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		String s = "D:/Temp/pictures/fdsgfdsg/";
		int[] arr = new int[] { 1, 2, 23, 4435, 12, 65, 94, 345464, 657 };
		long a = System.currentTimeMillis();
		Arrays.sort(arr, 2, 4);
		long b = System.currentTimeMillis();
		System.out.println((b - a) + "" + Arrays.toString(arr));
	}
}
