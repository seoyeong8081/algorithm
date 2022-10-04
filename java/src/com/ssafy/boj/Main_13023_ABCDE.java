package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> adjList = new ArrayList<List<Integer>>(N);
		for (int i = 0; i < N; i++) {
			adjList.add(i, new ArrayList<Integer>());
		}
		
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			adjList.get(from).add(to);
			adjList.get(to).add(from);
		}
		
		for (int i = 0; i < N; i++) {
//			System.out.println("------------" + i);
			if (dfs(i, adjList, new boolean[N], 1)) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
	}
	
	public static boolean dfs(int idx, List<List<Integer>> adjList, boolean[] isVisited, int depth) {
//		System.out.println("idx: " + idx + ", depth: " + depth);
		if (depth == 5) {
			return true;
		}
		
		isVisited[idx] = true;
//		System.out.println(Arrays.toString(isVisited));
//		boolean isDepthFive = false;
		
		for (int i = 0; i < adjList.get(idx).size(); i++) {
			int next = adjList.get(idx).get(i);
			if (!isVisited[next] && dfs(next, adjList, isVisited, depth + 1)) {
				return true;
			}
			
//			if (dfs(next, adjList, isVisited, depth + 1)) {
//				return true;
//			}
		}
		
		isVisited[idx] = false; // 필수!!!!!!
		return false;
	}
	
}
