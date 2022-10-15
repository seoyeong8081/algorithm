package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 플로이드-워샬은 시간상 유리하진 않음 코드 작성은 빨리 할 수 있음
// 메모이제이션이 시간상 제일 유리
public class Solution_5643_키순서5_Floyd {
	
	static int N, M;
	static int cnt;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			
			int[][] adjMatrix = new int[N+1][N+1];
			
			StringTokenizer st = null;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1; // a보다 b가 키가 크다
			}
			
			int answer = 0;
			
			for (int k = 1; k <= N; k++) { // 경유
				for (int i = 1; i <= N; i++) { // 출발
					if (i == k) continue;
					for (int j = 1; j <= N; j++) { // 도착
						if (adjMatrix[i][j] == 1) continue;
						adjMatrix[i][j] = adjMatrix[i][k] & adjMatrix[k][j];
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adjMatrix[i][0] += adjMatrix[i][j];
					adjMatrix[0][j] += adjMatrix[i][j];
				}
			}
			
			for (int k = 1; k <= N; k++) {
				if (adjMatrix[k][0] + adjMatrix[0][k] == N - 1) answer++;
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		
	}
	

}
