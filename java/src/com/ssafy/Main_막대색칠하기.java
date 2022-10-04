package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// f[n] = 2*f[n-1] + f[n-2]
public class Main_막대색칠하기 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 2;
		
		for (int i = 2; i <= n; i++) {
			f[i] = 2 * f[i - 1] + f[i - 2];
		}
		
		System.out.println(f[n]);
	}

}
