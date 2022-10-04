package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] RGB = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 3; j ++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N][3]; // 각각 해당 i를 RGB로 칠했을 때 최적값을 나타냄
		dp[0][0] = RGB[0][0];
		dp[0][1] = RGB[0][1];
		dp[0][2] = RGB[0][2];
		
		for (int i = 1; i < N; i++) {
			dp[i][0] = RGB[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = RGB[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = RGB[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
		
	}

}
