package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	public static int ans;
	public static char[][] board;
	public static int R, C;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = in.readLine().toCharArray();
		}
		
		dfs(0, 0, 0, 1);
		
		System.out.println(ans);
	}
	
	public static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	public static int[] dc = {0, 0, -1, 1};
	
	public static void dfs(int curRow, int curCol, int flag, int cnt) {
		
		flag = flag | 1<<(board[curRow][curCol] - 'A');
		
		for (int i = 0; i < dr.length; i++) {
			int nextRow = curRow + dr[i];
			int nextCol = curCol + dc[i];
			if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || 
					((flag & 1<<(board[nextRow][nextCol] - 'A')) != 0)) {
				if (cnt > ans) ans = cnt;
				continue;
			}
			dfs(nextRow, nextCol, flag, cnt + 1);
		}
	}
}
