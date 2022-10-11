package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		int N;
		int input;
		int pos;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			
			int[] dp = new int[N];
//			Arrays.fill(dp, 1001);
			
			// binary_search 이용
			st = new StringTokenizer(in.readLine());
			int dpSize = 0;
			for (int i = 0; i < N; i++) {
				input = Integer.parseInt(st.nextToken());
				pos = -Arrays.binarySearch(dp, 0, dpSize, input) - 1;
				dp[pos] = input;
				if (pos == dpSize) {
					dpSize++;
				}
				
//				// debug
//				System.out.println(pos);
			}
			
			
			out.append("#").append(tc).append(" ").append(dpSize).append("\n");
		}
		
		System.out.println(out);
	}
	
}
