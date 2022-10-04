package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1249_보급로dfs {
	
	static int[][] map = new int[100][100];
	static boolean[][] isVisited = new boolean[100][100];
	static int[][] mintime = new int[100][100];
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
//	static int[] dr = {-1, 1, 0, 0};
//	static int[] dc = {0, 0, -1, 1};
	static int N;
	
	static void dfs(int r, int c, int time) {
		if (r == N - 1 && c == N - 1) {
			mintime[r][c] = Math.min(mintime[r][c], time);
//			System.out.println(mintime[r][c]);
			return;
		}
//		if (time >= mintime[r][c]) return;
		mintime[r][c] = Math.min(mintime[r][c], time);
		
		isVisited[r][c] = true;
		
//		System.out.println("r: " + r + ", c: " + c + ", time: " + time);
		int nr, nc, ntime;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || isVisited[nr][nc]) continue;
			ntime = time + map[nr][nc];
			if (ntime >= mintime[nr][nc]) continue;
			dfs(nr, nc, ntime);
		}
		isVisited[r][c] = false;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		StringBuilder out = new StringBuilder();
		
		
		String input;
		
		
		for (int T = 1; T <= tc; T++) {
			N = Integer.parseInt(in.readLine());
			for (int i = 0; i < N; i++) {
				input = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
					mintime[i][j] = Integer.MAX_VALUE;
				}
			}
			
			
			dfs(0, 0, 0);
			
			out.append("#").append(T).append(" ").append(mintime[N-1][N-1]).append("\n");
		}
		
		System.out.println(out);
	}
	
}
