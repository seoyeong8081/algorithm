package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	
	static int[][] map;
	static int N;
	static int fish[] = new int[7];;
	
	static int time, sharkSize, eatNum;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		
		int sharkR = 0;
		int sharkC = 0;
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					map[i][j] = 0;
					sharkR = i;
					sharkC = j;
				} else if (map[i][j] != 0) {
					fish[map[i][j]]++;
				}
			}
		}
		
		time = 0;
		sharkSize = 2;
		eatNum = 0;
		
		
		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, -1, 1, 0};
		boolean isQueEmpty = false;
		while (true) {
			// 먹을 수 있는 물고기 있는지 체크
			boolean isEatPossible = false;
			int fishSearchIdx = Math.min(sharkSize, 7);
			for (int i = 1; i < fishSearchIdx; i++) {
				if (fish[i] != 0) {
					isEatPossible = true;
					break;
				}
			}
			if (!isEatPossible || isQueEmpty) break;
			
			// 큐에 현재 위치 넣기
			// PriorityQueue를 쓰니깐 매번 정렬해서 문제임 list에 넣고 필요할 때 정렬
//			PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
//				@Override
//				public int compare(int[] o1, int[] o2) {
//					return o1[2] == o2[2] ? o1[3] - o2[3] : o1[2] - o2[2] ;
//				}
//			});
			List<int[]> que = new ArrayList<>();
			boolean[][] isVisited = new boolean[N][N];
			que.add(new int[] {sharkR, sharkC, 0, 0, 0}); // r, c, 상어위치로부터 dr, dc, 거리
			isVisited[sharkR][sharkC] = true;
			
			int[] cur;
			int[] next = new int[5];
			int queSize;
			int eatableNum;
			EAT : while (!que.isEmpty()) {
				queSize = que.size();
				eatableNum = 0;
				while (queSize != 0) {
					cur = que.get(--queSize);
					que.remove(queSize);
					// poll할 때 먹을 수 있는 물고기인지 체크
					if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < sharkSize) {
						// 물고기 먹고 위치 바꾸기
						if (++eatNum == sharkSize) {
							eatNum = 0;
							sharkSize++;
						}
						sharkR = cur[0];
						sharkC = cur[1];
						fish[map[cur[0]][cur[1]]]--;
						map[sharkR][sharkC] = 0;
						time += cur[4];
						break EAT;
					}
					
					for (int i = 0; i < 4; i++) {
						next[0] = cur[0] + dr[i];
						next[1] = cur[1] + dc[i];
						// 자신보다 크기 큰 물고기 있는 칸은 못감
						if (next[0] < 0 || next[0] >= N || next[1] < 0 || next[1] >= N || isVisited[next[0]][next[1]] || map[next[0]][next[1]] > sharkSize) continue;
						
						next[2] = cur[2] + dr[i];
						next[3] = cur[3] + dc[i];
						// next로 넣으면 안되나???
						que.add(new int[] {next[0], next[1], next[2], next[3], cur[4] + 1});
						isVisited[next[0]][next[1]] = true;
						if (map[next[0]][next[1]] < sharkSize) eatableNum++;
					}
					if (que.isEmpty()) isQueEmpty = true;
				}
				if (eatableNum > 1) {
					que.sort(new Comparator<int[]>() {

						@Override
						public int compare(int[] o1, int[] o2) {
							return o1[2] == o2[2] ? o2[3] - o1[3] : o2[2] - o1[2] ;
						}
					});
				}
			}
			
		}
		System.out.println(time);
	}
	
	
	
}
