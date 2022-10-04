package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수 {

	public static int[] parents;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		int N, M;
		int cnt;
		List<Integer> representative = new ArrayList<Integer>();
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			cnt = 0;
			for (int i = 0; i <= N; i++) {
				if (!representative.contains(find_set(i))) {
					cnt++;
					representative.add(find_set(i));
				}
			}
			representative.clear();
			
			out.append("#").append(tc).append(" ").append(cnt - 1).append("\n");
		}
		
		System.out.println(out);
	}
	
	public static int find_set(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = find_set(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find_set(a);
		int bRoot = find_set(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

}
