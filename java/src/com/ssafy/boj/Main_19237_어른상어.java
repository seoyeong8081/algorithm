package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19237_어른상어 {
	
	static int N, M, k;
	static int map[][], smell[][][], priority[][][];
	static int fishNumSum;
	static int fishDir[], fishR[], fishC[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		fishR = new int[M + 1];
		fishC = new int[M + 1];
		map = new int[N][N];
		smell = new int[N][N][2]; // 상어넘버, 시간 (남은 시간이 아니라 처음 시작으로부터 시간)
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					smell[i][j][0] = map[i][j];
					smell[i][j][1] = 0;
					fishR[map[i][j]] = i;
					fishC[map[i][j]] = j;
				}
			}
		}
		
		fishDir = new int[M + 1];
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= M; i++) {
			fishDir[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		priority = new int[M + 1][4][4]; // 위 아래 왼족 오른쪽 향할 때 우선순위
		// 0:위 1:아래 2:왼 3:오
		for (int i = 1; i < M + 1; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(in.readLine());
				for (int l = 0; l < 4; l++) {
					priority[i][j][l] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}
		
		fishNumSum = M * (M + 1) / 2;
		int t = 1;
		for (; t <= 1000; t++) {
			moveSharks(t);
			if (fishNumSum == 1) break;
		}
		
		if (t == 1001) {
			System.out.println(-1);
		} else {
			System.out.println(t);
		}
	}
	
	// 0:위 1:아래 2:왼 3:오
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void moveSharks(int time) {
		// 업데이트 할 것들
//		map[][], smell[][][]
//		fishNumSum;
//		fishDir[], fishR[], fishC[];
		for (int i = 1; i <= M; i++) { // 1번 물고기부터 이동
			if (fishR[i] == -1) continue;
			int nr = -1, nc = -1;
			boolean isFind = false;
			for (int j = 0; j < 4; j++) {
				nr = fishR[i] + dr[priority[i][fishDir[i]][j]];
				nc = fishC[i] + dc[priority[i][fishDir[i]][j]];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				// 아무 냄새가 없는 칸 먼저
				if (smell[nr][nc][0] != 0 && smell[nr][nc][1] >= time - k) continue;
				
				fishDir[i] = priority[i][fishDir[i]][j];
				isFind = true;
				break;
			}
			
			if (!isFind) {
				// 그런 칸이 없다면 자신의 냄새가 있는 칸의 방향
				for (int j = 0; j < 4; j++) {
					nr = fishR[i] + dr[priority[i][fishDir[i]][j]];
					nc = fishC[i] + dc[priority[i][fishDir[i]][j]];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if (smell[nr][nc][0] != i) continue;
					
					fishDir[i] = priority[i][fishDir[i]][j];
					break;
				}
			}
			
			if (map[nr][nc] != 0 && map[nr][nc] < i) {
				fishNumSum -= i;
				map[fishR[i]][fishC[i]] = 0;
				fishR[i] = fishC[i] = -1;
			} else {
				map[fishR[i]][fishC[i]] = 0;
				map[nr][nc] = i;
				fishR[i] = nr;
				fishC[i] = nc;
			}
			
		}
		// 1번부터 냄새 남기기
		for (int i = 1; i <= M; i++) {
			if (fishR[i] == -1) continue;
			smell[fishR[i]][fishC[i]][0] = i;
			smell[fishR[i]][fishC[i]][1] = time;
		}
		
	}
	
}
