package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		
		int N, X;
		int map[][];
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			
			// 가로 탐색
			int pos;
			SearchRow : for (int i = 0; i < N; i++) {
				int j = 1;
				for (; j < N; j++) {
					if (map[i][j - 1] + 1 == map[i][j]) {
						pos = j - X;
						if (j - X < 0) continue SearchRow;
						for (int col = j - X; col < j; col++) {
							if (map[i][col] != map[i][j - 1]) continue SearchRow;
						}
					} else if (map[i][j - 1] - 1 == map[i][j]) {
						pos = j + X;
						if (j + X > N) continue SearchRow;
						for (int col = j; col < pos; col++) {
							if (map[i][col] != map[i][j]) continue SearchRow;
						}
						for (int col = pos; col < pos + X; col++) {
							if (col >= N) continue;
							if (map[i][col] > map[i][j]) continue SearchRow;
						}
					} else if (map[i][j - 1] == map[i][j]) {
						continue;
					} else {
						continue SearchRow;
					}
				}
				if (j == N) {
//					System.out.println("row : "+ i);
					cnt++;
				}
			}
			
			// 세로 탐색
			SearchCol : for (int j = 0; j < N; j++) {
				int i = 1;
				for (; i < N; i++) {
					if (map[i - 1][j] + 1 == map[i][j]) {
//						System.out.println(i + " " + j);
						pos = i - X;
						if (i - X < 0) continue SearchCol;
						for (int row = i - X; row < i; row++) {
							if (map[row][j] != map[i - 1][j]) continue SearchCol;
						}
					} else if (map[i - 1][j] - 1 == map[i][j]) {
//						System.out.println(i + " " + j);
						pos = i + X;
						if (i + X > N) continue SearchCol;
						for (int row = i; row < pos; row++) {
							if (map[row][j] != map[i][j]) continue SearchCol;
						}
						for (int row = pos; row < pos + X; row++) {
							if (row >= N) continue;
							if (map[row][j] > map[i][j]) continue SearchCol;
						}
					} else if (map[i - 1][j] == map[i][j]) {
						continue;
					} else {
						continue SearchCol;
					}
				}
				if (i == N) {
//					System.out.println("col : " + j);
					cnt++;
				}
			}
			
			out.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(out);
	}
	
}
