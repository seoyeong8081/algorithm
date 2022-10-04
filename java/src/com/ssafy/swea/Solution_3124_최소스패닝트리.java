package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {

	public static class Line implements Comparable<Line>{
		public int a, b, weight;

		public Line(int a, int b, int weight) {
			super();
			this.a = a;
			this.b = b;
			this.weight = weight;
		}

		@Override
		public int compareTo(Line o) {
//			return this.weight - o.weight;
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		int V, E;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			Line[] adjLine = new Line[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				adjLine[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(adjLine);
			
//			kruskal(adjLine);
			
//			make();
			int[] parents = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				parents[i] = i;
			}
			
			int cnt = 0;
			long ans = 0;
			
			for (int i = 0; i < E; i++) {
				if (union(adjLine[i].a, adjLine[i].b, parents)) {
					cnt++;
					ans += adjLine[i].weight;
					if (cnt == V - 1) break;
				}
			}
			
			out.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(out);
	}
	
	
	private static boolean union(int a, int b, int[] parents) {
		int aRoot = find_set(a, parents);
		int bRoot = find_set(b, parents);
		
		if (aRoot == bRoot) return false;
		
		parents[find_set(b, parents)] = find_set(a, parents);
		return true;
	}
	
	private static int find_set(int a, int[] parents) {
		if (parents[a] == a) {
			return a;
		} else {
			return parents[a] = find_set(parents[a], parents);
		}
	}
	
}
