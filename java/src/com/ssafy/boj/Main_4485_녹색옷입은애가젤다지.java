package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		int N;
		int[][] map;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int[][] D;
		boolean[][] isVisited;
		int pb = 0;
		
		while (true) {
			N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// Dijkstra
			D = new int[N][N];
			isVisited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					D[i][j] = Integer.MAX_VALUE;
				}
			}
			D[0][0] = map[0][0];
			
			int min, minr, minc;
			int nr, nc;
			while (true) {
				// 아직 방문안한 최소값 찾기
				min = Integer.MAX_VALUE;
				minr = -1;
				minc = -1;
				for (int i = 0; i < N; i++) {
					if (D[i][0] == Integer.MAX_VALUE) break;
					for (int j = 0; j < N; j++) {
						if (!isVisited[i][j] && D[i][j] < min) {
							min = D[i][j];
							minr = i;
							minc = j;
						}
					}
				}
				
				// 방문처리
				if (minr == N - 1 && minc == N - 1) break;
				isVisited[minr][minc] = true;
				
				// 주변 점들 D 업데이트
				for (int i = 0; i < 4; i ++) {
					nr = minr + dr[i];
					nc = minc + dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited[nr][nc]
							&& D[nr][nc] > D[minr][minc] + map[nr][nc]) {
						D[nr][nc] = D[minr][minc] + map[nr][nc];
					}
				}
			}
			
			out.append("Problem ").append(++pb).append(": ").append(D[N - 1][N - 1]).append("\n");
		}
		
		System.out.println(out);
	}
	
}
