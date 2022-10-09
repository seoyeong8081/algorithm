package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	
	static int maxNum = 0;
	static List<int[]> wallPossiblePos = new ArrayList<int[]>();
	static List<int[]> bacteria = new ArrayList<int[]>();
	static int wallPossiblePosNum = 0;
	static int[] wall = new int[3];
	static int map[][];
	static int N, M;

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
				if (map[i][j] == 0) {
					wallPossiblePos.add(new int[] {i, j});
					wallPossiblePosNum++;
				} else if (map[i][j] == 2) {
					bacteria.add(new int[] {i, j});
				}
			}
		}
		
		combination(0, 0);
		
		System.out.println(maxNum);
	}
	
	private static void combination(int cnt, int start) {
		if (cnt == 3) {
			count();
			return;
		}
		
		for (int i = start; i < wallPossiblePosNum; i++) {
			wall[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void count() {
		for (int i = 0; i < 3; i++) {
			int[] wallInstall = wallPossiblePos.get(wall[i]);
			map[wallInstall[0]][wallInstall[1]] = 1;
		}
		
		Queue<int[]> que = new ArrayDeque<>();
		boolean isVisited[][] = new boolean[N][M];
		for (int i = 0; i < bacteria.size(); i++) {
			int[] cur = bacteria.get(i);
			que.offer(cur);
			isVisited[cur[0]][cur[1]] = true;
		}
		
		int[] cur;
		int nr, nc;
		while (!que.isEmpty()) {
			cur = que.poll();
			
			for (int i = 0; i < 4; i++) {
				nr = cur[0] + dr[i];
				nc = cur[1] + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != 0 || isVisited[nr][nc]) continue;
				que.offer(new int[] {nr, nc});
				isVisited[nr][nc] = true;
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !isVisited[i][j]) cnt++;
			}
		}
		
		maxNum = Math.max(maxNum, cnt);
		
		
		for (int i = 0; i < 3; i++) {
			int[] wallInstall = wallPossiblePos.get(wall[i]);
			map[wallInstall[0]][wallInstall[1]] = 0;
		}
	}
	
}
