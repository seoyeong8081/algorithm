package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서3_DFS_역인접행렬 {
	
	static int N, M;
	static int cnt;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			
			int[][] adjMatrix = new int[N+1][N+1];
			int[][] radjMatrix = new int[N+1][N+1];
			
			StringTokenizer st = null;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				radjMatrix[b][a] = adjMatrix[a][b] = 1; // a보다 b가 키가 크다
			}
			
			int answer = 0;
			
			for (int i = 1; i <= N; i++) {
				cnt = 0;
				dfs(i, adjMatrix, new boolean[N+1]);
				dfs(i, radjMatrix, new boolean[N+1]);
				if (cnt == N - 1) answer++;
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		
	}
	
	static void dfs(int cur, int[][] adjMatrix, boolean[] visited) {
	
		visited[cur] = true;
		
		for (int i = 1; i <= N; i++) {
			if (adjMatrix[cur][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i, adjMatrix, visited);
			}
		}
		
	}

}
