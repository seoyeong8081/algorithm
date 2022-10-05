package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int R, C;
		StringTokenizer st;
		int cnt = 0;
		int map[][];
		boolean isVisited[][];
		int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
		int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};
		List<int[]> list;
		Queue<int[]> que;
		while (true) {
			st = new StringTokenizer(in.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			if (R == 0 && C == 0) break;
			
			map = new int[R][C];
			isVisited = new boolean[R][C];
			cnt = 0;
			
			list = new ArrayList<>();
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						list.add(new int[] {i, j});
					}
				}
			}
			
			// list로 1인 곳 저장해두자
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int[] cur = list.get(i);
				if (!isVisited[cur[0]][cur[1]]) {
					cnt++;
					que = new ArrayDeque<int[]>();
					que.offer(new int[] {cur[0], cur[1]});
					isVisited[cur[0]][cur[1]] = true;
					while (!que.isEmpty()) {
						int[] queCur = que.poll();
						int nr, nc;
						for (int search = 0; search < 8; search++) {
							nr = queCur[0] + dr[search];
							nc = queCur[1] + dc[search];
							if (nr < 0 || nr >= R || nc < 0 || nc >= C || isVisited[nr][nc] || map[nr][nc] == 0) continue;
							que.offer(new int[] {nr, nc});
							isVisited[nr][nc] = true;
						}
					}
				}
			}
			
			out.append(cnt).append("\n");
		}
		System.out.println(out);
	}
	
}
