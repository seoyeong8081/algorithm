package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {
	
	static int D, W, K;
	static int map[][];
	
	public static boolean check() {
		
		//int start;
		int cnt;
		Search : for (int col = 0; col < W; col++) {
			//start = map[0][col];
			cnt = 1;
			for (int row = 1; row < D; row++) {
				if (map[row][col] == map[row - 1][col]) {
					cnt++;
				} else {
					cnt = 1;
				}
				
				if (cnt == K) {
					continue Search;
				}
			}
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 1 ~ K-1 까지 시도
			System.out.println(check());
			
			out.append("#").append(tc).append(" ").append("\n");
		}
		
		System.out.println(out);
	}
	
}
