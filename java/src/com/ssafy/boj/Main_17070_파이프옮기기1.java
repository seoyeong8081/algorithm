package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int[][] map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] dp = new int[N][N][3]; // 1: 가로로 있는 경우, 2: 세로, 3: 대각선
		for (int i = 1; i < N; i++) {
			if (map[0][i] == 0)
				dp[0][i][0] = 1; // (0,1)...(0,N-1)에 가로로 있는 경우 1가지
			else break;
		}
		
		for (int row = 1; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col] == 1) continue;
				
				// 가로로 있는 경우
				if (col > 0) {
					dp[row][col][0] = dp[row][col - 1][0] + dp[row][col - 1][2];
				}
				
				// 세로로 있는 경우
				if (row > 0) {
					dp[row][col][1] = dp[row - 1][col][1] + dp[row - 1][col][2];
				}
				
				// 대각선으로 있는 경우
				if (row > 0 && col > 0 && map[row][col - 1] == 0 && map[row - 1][col] == 0) {
					dp[row][col][2] = dp[row - 1][col - 1][0] + dp[row - 1][col - 1][1] + dp[row - 1][col - 1][2];
				}
			}
		}
		
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
		
//		// debugging
//		int[][] ans = new int[N][N];
//		for (int row = 0; row < N; row++) {
//			for (int col = 0; col < N; col++) {
//				ans[row][col] = dp[row][col][0] + dp[row][col][1] + dp[row][col][2];
//				System.out.print(ans[row][col] + " ");
//			}
//			System.out.println();
//		}
	}

}
