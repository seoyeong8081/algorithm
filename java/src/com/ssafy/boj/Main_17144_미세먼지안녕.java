package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
	
	static int[][] map;
	static int[][] maptmp;
	static int R, C, T;
	static int airRefresherR;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		maptmp = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j <C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			if (map[i][0] == -1) {
				airRefresherR = i; // 아래 열이 들어감(덮어쓰여짐)
				maptmp[i][0] = -1;
			}
		}
		
		boolean toggle = true; // map과 maptmp 왔다갔다 / 하나는 결과 하나는 더할 용도
		for (int cnt = 0; cnt < T; cnt++) {
			if (toggle) {
				diffusion(map, maptmp);
				
//				//test
//				for (int i = 0; i < R; i++) {
//					for (int j = 0; j < C; j++) {
//						System.out.print(maptmp[i][j] + " "); //test
//					}
//					System.out.println(); //test
//				}
//				System.out.println();
				
				airRefresh(maptmp);
				
//				//test
//				for (int i = 0; i < R; i++) {
//					for (int j = 0; j < C; j++) {
//						System.out.print(maptmp[i][j] + " "); //test
//					}
//					System.out.println(); //test
//				}
//				System.out.println();
				toggle = false;
			} else {
				diffusion(maptmp, map);
				airRefresh(map);
				toggle = true;
			}
			
		}
		
		int ans = 0;
		if (toggle) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) ans += map[i][j];
					
//					System.out.print(map[i][j] + " "); //test
				}
//				System.out.println(); //test
			}
		} else {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (maptmp[i][j] > 0) ans += maptmp[i][j];
//					System.out.print(maptmp[i][j] + " "); //test
				}
//				System.out.println();//test
			}
		}
		
		System.out.println(ans);
	}
	
	public static void diffusion(int[][] map1, int[][] map2) {
		// map2 초기화
		for (int i = 0; i < R; i++) {
			Arrays.fill(map2[i], 0);
		}
		map2[airRefresherR - 1][0] = -1;
		map2[airRefresherR][0] = -1;
		
		
//		//test
//		System.out.println("test");
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map2[i][j] + " "); //test
//			}
//			System.out.println(); //test
//		}
//		System.out.println();
		
		
		
		// map2에 확산된거 누적하여 저장
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map1[i][j] > 0) {
					int res = map1[i][j] / 5;
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C && map1[nr][nc] != -1) {
							map2[nr][nc] += res;
							map1[i][j] -= res;
						}
					}
					map2[i][j] += map1[i][j];
				}
			}
		}
	}
	
	public static void airRefresh(int[][] map) {
		// 위쪽 공기청정기 바람 - 반시계방향
		for (int row = airRefresherR - 2; row > 0; row--) { // 왼쪽
			map[row][0] = map[row - 1][0];
		}
		for (int col = 0; col < C - 1; col++) { // 위쪽
			map[0][col] = map[0][col + 1];
		}
		for (int row = 0; row < airRefresherR - 1; row++) { // 오른쪽
			map[row][C - 1] = map[row + 1][C - 1];
		}
		for (int col = C - 1; col > 1; col--) {
			map[airRefresherR - 1][col] = map[airRefresherR - 1][col - 1];
		}
		map[airRefresherR - 1][1] = 0;
		
		// 아래쪽 공기청정기 바람 - 시계방향
		for (int row = airRefresherR + 1; row < R - 1; row++) { // 왼쪽
			map[row][0] = map[row + 1][0];
		}
		for (int col = 0; col < C - 1; col++) { // 아래쪽
			map[R - 1][col] = map[R - 1][col + 1];
		}
		for (int row = R - 1; row > airRefresherR; row--) { // 오른쪽
			map[row][C - 1] = map[row - 1][C - 1];
		}
		for (int col = C - 1; col > 1; col--) { // 위쪽
			map[airRefresherR][col] = map[airRefresherR][col - 1];
		}
		map[airRefresherR][1] = 0;
	}
	
}
