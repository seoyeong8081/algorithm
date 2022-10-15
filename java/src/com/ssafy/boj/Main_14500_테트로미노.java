package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	
	static int N, M;
	static int map[][];
	
	
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				search(i, j);
			}
		}
		
		System.out.println(ans);
	}
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};

	private static void search(int i, int j) {
		if (!isOutOfMap(i, j + 3)) { // 1 x 4
			ans = Math.max(ans, map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3]);
		}
		if (!isOutOfMap(i + 3, j)) { // 4 x 1
			ans = Math.max(ans, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j]);
		}
		if (!isOutOfMap(i + 1, j + 1)) { // 2 x 2
			ans = Math.max(ans, map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1]);
		}
		if (!isOutOfMap(i + 2, j + 1)) { // 3 x 2
			int left2 = map[i][j] + map[i+1][j];
			int right2 = map[i][j+1] + map[i+1][j+1];
			int left3 = left2 + map[i+2][j];
			int right3 = right2 + map[i+2][j+1];
			
			ans = Math.max(ans, left3 + map[i][j+1]);
			ans = Math.max(ans, left3 + map[i+1][j+1]);
			ans = Math.max(ans, left3 + map[i+2][j+1]);
			ans = Math.max(ans, right3 + map[i][j]);
			ans = Math.max(ans, right3 + map[i+1][j]);
			ans = Math.max(ans, right3 + map[i+2][j]);
			ans = Math.max(ans, left2 + map[i+1][j+1] + map[i+2][j+1]);
			ans = Math.max(ans, right2 + map[i+1][j] + map[i+2][j]);
		}
		if (!isOutOfMap(i + 1, j + 2)) { // 2 x 3
			int up2 = map[i][j] + map[i][j+1];
			int down2 = map[i+1][j] + map[i+1][j+1];
			int up3 = up2 + map[i][j+2];
			int down3= down2 + map[i+1][j+2];
			
			ans = Math.max(ans, up3 + map[i+1][j]);
			ans = Math.max(ans, up3 + map[i+1][j+1]);
			ans = Math.max(ans, up3 + map[i+1][j+2]);
			ans = Math.max(ans, down3 + map[i][j]);
			ans = Math.max(ans, down3 + map[i][j+1]);
			ans = Math.max(ans, down3 + map[i][j+2]);
			ans = Math.max(ans, up2 + map[i+1][j+1] + map[i+1][j+2]);
			ans = Math.max(ans, down2 + map[i][j+1] + map[i][j+2]);
		}
	}
	
	private static boolean isOutOfMap(int r, int c) {
		return r < 0 || r >= N || c < 0 || c >= M;
	}
	
}
