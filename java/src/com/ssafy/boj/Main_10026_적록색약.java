package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10026_적록색약 {

	public static char[][] map;
	public static boolean[][] isVisited;
	public static boolean[][] isVisited2;
	public static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		isVisited = new boolean[N][N];
		isVisited2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		int cnt = 0;
		int cnt2 = 0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (!isVisited[row][col]) {
					dfs(row, col, map[row][col], 1);
					cnt++;
				}
				if (!isVisited2[row][col]) {
					if (map[row][col] == 'B')
						dfs(row, col, 'B', 2);
					else 
						dfs2(row, col);
					cnt2++;
				}
			}
		}
		
		System.out.println(cnt + " " + cnt2);
	}

	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	private static void dfs(int row, int col, char ch, int who) {
		if (who == 1) {
			isVisited[row][col] = true;
			
			int nr, nc;
			for (int i = 0 ; i < 4; i++) {
				nr = row + dr[i];
				nc = col + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited[nr][nc] && map[nr][nc] == ch) {
					dfs(nr, nc, ch, who);
				}
			}
		}
		else {
			isVisited2[row][col] = true;
			
			int nr, nc;
			for (int i = 0 ; i < 4; i++) {
				nr = row + dr[i];
				nc = col + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited2[nr][nc] && map[nr][nc] == ch) {
					dfs(nr, nc, ch, who);
				}
			}
		}
		
		
	}
	
	private static void dfs2(int row, int col) {
		isVisited2[row][col] = true;
		
		int nr, nc;
		for (int i = 0 ; i < 4; i++) {
			nr = row + dr[i];
			nc = col + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited2[nr][nc]) {
				if (map[nr][nc] == 'G' || map[nr][nc] == 'R')
					dfs2(nr, nc);
			}
		}
	}
	
}
