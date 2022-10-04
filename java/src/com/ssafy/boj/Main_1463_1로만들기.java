package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 0;
//		dp[2] = 1;
//		dp[3] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
		}
		
		System.out.println(dp[N]);
	}
	
}
