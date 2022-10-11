package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서1_BFS {
	
	static int N, M, adjMatrix[][];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			
			adjMatrix = new int[N+1][N+1];
			
			StringTokenizer st = null;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1; // a보다 b가 키가 크다
			}
			
			int answer = 0;
			
			for (int i = 1; i <= N; i++) {
				if (gtBFS(i) + ltBFS(i) == N - 1) answer++;
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		
	}
	
	static int gtBFS(int start) {
		int cnt = 0;
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N + 1];
	
		visited[start] = true;
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 1; i <= N; i++) {
				if (adjMatrix[cur][i] == 1 && !visited[i]) {
					cnt++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		
		return cnt;
	}

	static int ltBFS(int start) {
		int cnt = 0;
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N + 1];
	
		visited[start] = true;
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 1; i <= N; i++) {
				if (adjMatrix[i][cur] == 1 && !visited[i]) {
					cnt++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		
		return cnt;
	}
}
