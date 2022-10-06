package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17086_아기상어2_2 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];
//		int dist[][] = new int[N][M];
//		for (int i = 0; i < N; i++) {
//			Arrays.fill(dist[i], 3000);
//		}
		
		Queue<int[]> que = new ArrayDeque<int[]>();
		boolean isVisited[][] = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					que.add(new int[] {i, j});
					isVisited[i][j] = true;
//					dist[i][j] = 0;
				}
			}
		}
		
		int ans = 0;
		int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		
		int[] cur;
		int nr, nc;
		
		int distance = 0;
		int size;
		while (!que.isEmpty()) {
			size = que.size();
			distance++;
			
			while (size != 0) {
				size--;
				cur = que.poll();
				for (int idx = 0; idx < 8; idx++) {
					nr = cur[0] + dr[idx];
					nc = cur[1] + dc[idx];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc] || map[nr][nc] == 1) continue;
					que.offer(new int[] {nr, nc});
					map[nr][nc] = distance;
					isVisited[nr][nc] = true;
				}
			}
		}

		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans = Math.max(ans, map[i][j]);
			}
		}
		System.out.println(ans);
	}
	
}
