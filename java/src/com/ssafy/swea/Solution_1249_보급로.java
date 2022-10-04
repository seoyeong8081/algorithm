package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_1249_보급로 {
	
	static int[][] map = new int[100][100];
	static int[][] mintime = new int[100][100];

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		StringBuilder out = new StringBuilder();
		
		int N;
		String input;
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int nr, nc, ntime;
		
		for (int T = 1; T <= tc; T++) {
			Queue<int[]> que = new ArrayDeque<int[]>();
			N = Integer.parseInt(in.readLine());
			for (int i = 0; i < N; i++) {
				input = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
					mintime[i][j] = Integer.MAX_VALUE;
				}
			}
			
			que.offer(new int[] {0, 0, 0});
			mintime[0][0] = 0;
			
			while (!que.isEmpty()) {
				int[] current = que.poll();
				int r = current[0];
				int c = current[1];
				int time = current[2];
				
				for (int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					ntime = time + map[nr][nc];
					if (ntime < mintime[nr][nc]) {
						mintime[nr][nc] = ntime;
						que.offer(new int[] {nr, nc, ntime});
					}
				}
			}
			
			
			
			out.append("#").append(T).append(" ").append(mintime[N-1][N-1]).append("\n");
		}
		
		System.out.println(out);
	}
	
}
