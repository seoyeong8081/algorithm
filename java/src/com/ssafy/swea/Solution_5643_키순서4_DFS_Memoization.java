package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서4_DFS_Memoization {
	
	static int N, M;
	static int cnt;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			
			int[][] adjMatrix = new int[N+1][N+1];
			
			for (int i = 1; i <= N; i++) adjMatrix[i][0] = -1; // 탐색하지 않은 상태의 초기값
			
			StringTokenizer st = null;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1; // a보다 b가 키가 크다
			}
			
			int answer = 0;
			
			for (int i = 1; i <= N; i++) {
				if (adjMatrix[i][0] == -1) dfs(i, adjMatrix);
			}
			
			// 모든 정점이 알고 있는 관계로 탐색을 마친 상태 (큰 정점을 따라 탐색해서 간접관계를 직접관계로 다 반영해서 인접행렬 업데이트)
			// 열 기준 정보를 확인하면 자신보다 작은 정점을 파악 가능
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					adjMatrix[0][k] += adjMatrix[i][k];
				}
				if (adjMatrix[k][0] + adjMatrix[0][k] == N - 1) answer++;
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		
	}
	
	static void dfs(int cur, int[][] adjMatrix) {
	
		for (int i = 1; i <= N; i++) {
			if (adjMatrix[cur][i] == 1) {
				
				if (adjMatrix[i][0] == -1) dfs(i, adjMatrix);
				
				// 나보다 큰 정점의 탐색정보를 메모
				if (adjMatrix[i][0] > 0) { // i보다 큰 정점이 존재 : cur < i < j를 만족하는 j 존재 => cur < j 상태로 메모
					for (int j = 1; j <= N; j++) {
						if (adjMatrix[i][j] == 1) adjMatrix[cur][j] = 1;
					}
				}
			}
		}
		
		// 자신보다 큰 ㅈ어점의 탐색을 모두 완료 메모하기
		int cnt = 0;
		for (int k = 1; k <= N; k++) cnt += adjMatrix[cur][k];
		
		adjMatrix[cur][0] = cnt;
	}

}
