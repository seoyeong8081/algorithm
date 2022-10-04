package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		int N, M, max;
		String str = "";
		for (int i = 0; i < tc; i++) {
			str = in.readLine();
			StringTokenizer st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for (int row = 0; row < N; row++) {
				str = in.readLine();
				st = new StringTokenizer(str);
				for (int col = 0; col < N; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			max = Integer.MIN_VALUE;
			int tmp = 0;
			
			for (int row = 0; row < N - M + 1; row++) {
				for (int col = 0; col < N - M + 1; col++) {
					tmp = countM(arr, M, row, col);
					if (tmp > max) max = tmp;
				}
			}
			
			out.append("#").append(i+1).append(" ").append(max).append("\n");
		}
		System.out.println(out);
	}
	
	public static int countM(int[][] arr, int M, int x, int y) {
		int ans = 0;
		for (int row = 0; row < M; row++) {
			for (int col = 0; col < M; col++) {
				ans += arr[x + row][y + col];
			}
		}
		return ans;
	}

}
