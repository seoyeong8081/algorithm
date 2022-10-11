package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		int N;
		int map[][];
		int floydWarshall[][];
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			floydWarshall = new int[N][N];
			int MAX_VALUE = Integer.MAX_VALUE / 3;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0) {
						floydWarshall[i][j] = MAX_VALUE;
					} else {
						floydWarshall[i][j] = map[i][j];
					}
				}
			}
			
			for (int k = 0; k < N; k++) { // 경유지
				for (int i = 0; i < N; i++) { // 출발지
					for (int j = 0; j < N; j++) { // 도착지
						floydWarshall[i][j] = Math.min(floydWarshall[i][k] + floydWarshall[k][j], floydWarshall[i][j]);
					}
				}
			}
			
			int	cc[] = new int[N];
//			int minIdx = -1;
			int minCC = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						cc[i] += floydWarshall[i][j];
					}
				}
				if (cc[i] < minCC) {
//					minIdx = i + 1;
					minCC = cc[i];
				}
			}
			
//			// debugging
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(floydWarshall[i][j] + " ");
//				}
//				System.out.println();
//			}
//			for (int i = 0; i < N; i++) {
//				System.out.println(cc[i]);
//			}
			out.append("#").append(tc).append(" ").append(minCC).append("\n");
		}
		
		System.out.println(out);
	}
	
}
