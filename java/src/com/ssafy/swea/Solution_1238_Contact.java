package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_1238_Contact {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int dataLen;
		int start;
		String input;
		StringTokenizer st;
		int from, to;
		List<Set<Integer>> adjList = new ArrayList<Set<Integer>>(101);
		for (int i = 0; i < 101; i++) {
			adjList.add(new HashSet<Integer>());
		}
		Queue<Integer> queue = new ArrayDeque<Integer>();
		int curQueueSize, tmp;
		int ans = 0;
		boolean[] isVisited = new boolean[101];
		int tc = 0;
		
		while ((input = in.readLine()) != null && !input.isEmpty()) {
			//input 받아서 adjList에 넣기
			st = new StringTokenizer(input);
			dataLen = Integer.parseInt(st.nextToken()) / 2;
			start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < dataLen; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
//				if (adjList.get(from) == null) {
//					adjList.add(from, new HashSet<Integer>());
//				}
				adjList.get(from).add(to);
			}
			
			// BFS
			queue.offer(start);
			isVisited[start] = true;
			
			while (!queue.isEmpty()) {
				ans = Integer.MIN_VALUE;
				curQueueSize = queue.size();
				
				while (curQueueSize != 0) {
					tmp = queue.poll();
					ans = Math.max(ans, tmp);
					curQueueSize--;
					
					for (Integer adjNode: adjList.get(tmp)) {
						if (!isVisited[adjNode]) {
							queue.offer(adjNode);
							isVisited[adjNode] = true;
						}
					}
				}
			}
			
			out.append("#").append(++tc).append(" ").append(ans).append("\n");
			
			// adjList clear해주기 (hashset도 clear해야하나?)
			// queue도 clear
			// isVisited false로 초기화
//			adjList.clear();
			for (int i = 0; i < 101; i++) {
				adjList.get(i).clear();
			}
			queue.clear();
			for (int i = 0; i < isVisited.length; i++) {
				isVisited[i] = false;
			}
		}
		
		System.out.println(out);
	}
}
