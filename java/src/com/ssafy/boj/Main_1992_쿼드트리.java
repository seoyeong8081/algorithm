package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {
	public static char[][] arr;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		arr = new char[N][N];
		for (int row = 0; row < N; row++) {
			arr[row] = in.readLine().toCharArray();
		}
		
		if (isSame(0, 0, N)) {
			System.out.print(arr[0][0]);
			return;
		}
		quardTree(0, 0, N);
	}
	
	public static void quardTree(int startR, int startC, int len) {
		if (len == 1) {
			System.out.print("(");
			System.out.print(arr[startR][startC]);
			System.out.print(arr[startR][startC + 1]);
			System.out.print(arr[startR + 1][startC]);
			System.out.print(arr[startR + 1][startC + 1]);
			System.out.print(")");
			return;
		}
		
		
		int halflen = len / 2;
		System.out.print("(");
		//왼쪽위
		if (isSame(startR, startC, halflen)) {
			System.out.print(arr[startR][startC]);
		} else {
			quardTree(startR, startC, halflen);
		}
		
		//오른쪽위
		if (isSame(startR, startC + halflen, halflen)) {
			System.out.print(arr[startR][startC + halflen]);
		} else {
			quardTree(startR, startC + halflen, halflen);
		}
		
		//왼쪽아래
		if (isSame(startR + halflen, startC, halflen)) {
			System.out.print(arr[startR + halflen][startC]);
		} else {
			quardTree(startR + halflen, startC, halflen);
		}
		
		//오른쪽아래
		if (isSame(startR + halflen, startC + halflen, halflen)) {
			System.out.print(arr[startR + halflen][startC + halflen]);
		} else {
			quardTree(startR + halflen, startC + halflen, halflen);
		}
		
		System.out.print(")");
	}
	
	public static boolean isSame(int startR, int startC, int len) {
		char element = arr[startR][startC];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (arr[startR + i][startC +j] != element) {
					return false;
				}
			}
		}
		return true;
	}
	
}
