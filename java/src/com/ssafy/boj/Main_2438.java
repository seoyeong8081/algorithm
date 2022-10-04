package com.baekjoon.level1;

import java.util.Scanner;

public class Main2438 {
	
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String star = "";
		
		for (int i = 0; i < N; i++) {
			star += "*";
			System.out.println(star);
		}
		
		sc.close();
	}
	
}
