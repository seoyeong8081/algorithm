package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// BFS로 풀어야하나? 공기와 접촉된 칸을 어떻게 찾지???
		// 테두리부터 시작해서 BFS나 DFS하면 될듯!!
		int time = -1;
		int cnt = 0;
		int cntBef = 0;
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int nr, nc;
		do {
			Queue<int[]> que = new ArrayDeque<>();
			boolean isVisited[][] = new boolean[R][C];
			que.offer(new int[] {0, 0});
			isVisited[0][0] = true;
			time++;
			cntBef = cnt;
			cnt = 0;
			
			while (!que.isEmpty()) {
				// isVisited 먼저 체크하고 0인지 체크하기
				int[] cur = que.poll();
				
				for (int i = 0; i < 4; i++) {
					nr = cur[0] + dr[i];
					nc = cur[1] + dc[i];
					if (nr < 0 || nr >= R || nc < 0 || nc >= C || isVisited[nr][nc]) continue;
					
					if (map[nr][nc] == 1) {
						map[nr][nc] = 0;
						cnt++;
						isVisited[nr][nc] = true;
					} else {
						que.offer(new int[] {nr, nc});
						isVisited[nr][nc] = true;
					}
				}
			}
		} while (cnt > 0);
		
		System.out.print(time + "\n" + cntBef);
	}

}
