package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Scanner;

public class Main_2839_설탕배달 {

	public static void main(String[] args) throws Exception{
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int five = N / 5;
		int residue = 0;
		
		int answer = -1;
		int temp = 0;
//		while (five * 5 <= N) { //three 로 바꾸고 break 넣기?
//			residue = N - 5 * five;
//			if (residue % 3 == 0) {
//				temp = five + residue / 3;
//				if (temp < answer)
//					answer = temp;
//			}
//			five++;
//		}
		residue = N - 5 * five;
		while (five >= 0) { //three 로 바꾸고 break 넣기?
			if (residue % 3 == 0) {
				temp = five + residue / 3;
				answer = temp;
				break;
			}
			residue += 5;
			five--;
		}
		
		System.out.println(answer);
		
//		sc.close();
	}
	
}
