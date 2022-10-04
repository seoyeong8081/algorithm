package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_아파트색칠하기 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] f = new int[N + 1];
		
		f[0] = 1;
		f[1] = 2;
		
		for (int i = 2; i <= N; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		
		System.out.println(f[N]);
		
	}

}
