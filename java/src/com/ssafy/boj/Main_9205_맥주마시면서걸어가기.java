package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// dfs로? nono BFS!
public class Main_9205_맥주마시면서걸어가기 {
	
//	static int[] home;
//	static int[] festival;
	static List<int[]> list;
	static boolean isVisited[];
	static int n;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
//			home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
//			festival = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list = new ArrayList<int[]>();
			isVisited = new boolean[n + 1];
			for (int i = 0; i < n + 1; i++) {
				st = new StringTokenizer(in.readLine());
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			if (bfs(x, y)) {
				out.append("happy\n");
			} else {
				out.append("sad\n");
			}
			
			
		}
		System.out.println(out);
	}

//	private static boolean dfs(int x, int y) {
//		int[] cur;
//		for (int i = 0; i < n + 1; i++) {
//			cur = list.get(i);
//			if (!isVisited[i] && distance(x, y, cur[0], cur[1]) <= 1000) {
//				if (i == n) return true;
//				
//				isVisited[i] = true;
//				if (dfs(cur[0], cur[1])) return true;
//				isVisited[i] = false;
//			}
//		}
//		
//		return false;
//	}

	private static boolean bfs(int x, int y) {
		Queue<int[]> que = new ArrayDeque<int[]>();
		que.offer(new int[] {x, y});
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			for (int i = 0; i < n + 1; i++) {
				if (!isVisited[i]) {
					int[] next = list.get(i);
					if (distance(next[0], next[1], cur[0], cur[1]) <= 1000) {
						if (i == n) return true;
						
						isVisited[i] = true;
						que.offer(next);
					}
					
				}
			}
			
		}
		
		return false;
	}
	
	private static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	
}
