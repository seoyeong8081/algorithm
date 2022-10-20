package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_9370_미확인도착지 {
	
	public static class Node {
		int from, to;
		int d;
		
		public Node(int from, int to, int d) {
			this.from = from;
			this.to = to;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		int n, m, t;
		int s, g, h;
		int a, b, d;
		while (T-- > 0) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			@SuppressWarnings("unchecked")
			List<Node>[] adjList = new ArrayList[n+1];
			
			while (m-- > 0) {
				st = new StringTokenizer(in.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				if (adjList[a] == null) {
					adjList[a] = new ArrayList<Node>();
				}
				if (adjList[b] == null) {
					adjList[b] = new ArrayList<Node>();
				}
				adjList[a].add(new Node(a, b, d));
				adjList[b].add(new Node(b, a, d));
			}

			List<Integer> ends = new ArrayList<>();
			List<Integer> removes = new ArrayList<>();
			while (t-- > 0) {
				ends.add(Integer.parseInt(in.readLine()));
			}
			
			//Dijkstra
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			boolean isVisited[] = new boolean[n+1];
			int D[] = new int[n+1];
			Arrays.fill(D, Integer.MAX_VALUE);
			isVisited[s] = true;
			D[s] = 0;
			for (Node node : adjList[s]) {
				//node.setD(D[s] + node.getD());
				D[node.to] = node.d;
				if ((node.from == g && node.to == h) || (node.from == h && node.to == g)) {
					pq.offer(new int[] {node.from, node.to, node.d, 1});
					continue;
				}
				pq.offer(new int[] {node.from, node.to, node.d, 0}); // from, to, distance, gh 포함하는지
			}
			// 거리 체크할 필요가 없으니까 D배열 만들 필요 없음 무슨 소리야 다익스트라 알고리즘에 필요함
			int[] cur;
			while (!pq.isEmpty()) {
				cur = pq.poll(); // to가 unvisited일 때까지 꺼내야함
				if (isVisited[cur[1]]) continue;
//				if (cur[3] == 0) {
////					ends.remove(new Integer(cur[1]));
//					removes.add(new Integer(cur[1]));
//				}
				if (cur[3] == 1) {
//					ends.remove(new Integer(cur[1]));
					removes.add(new Integer(cur[1]));
				}
				if (cur[0] == g && cur[1] == h) cur[3] = 1;
				if (cur[0] == h && cur[1] == g) cur[3] = 1;
				//System.out.println(Arrays.toString(D));
				//System.out.println(Arrays.toString(cur));
				isVisited[cur[1]] = true;
				
				// break 조건
				boolean isEnd = true;
				for (int end : ends) {
					if (!isVisited[end]) {
						isEnd = false;
						break;
					}
				}
				if (isEnd) break;
				
				//D[cur[1]] = cur[2]; // 넣을 때 해주지 않나?
				for (Node node : adjList[cur[1]]) { // 거리 비교해서 작으면 넣어야지
					if (D[node.from] + node.d <= D[node.to]) {
						D[node.to] = D[node.from] + node.d;
						pq.offer(new int[] {node.from, node.to, D[node.from] + node.d, cur[3]});
					}
				}
			}
			
			for (int i = ends.size() - 1; i >= 0; i--) {
				if (!removes.contains(new Integer(ends.get(i)))) {
					ends.remove(i);
				}
			}
			
			ends.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
			for (int end : ends) {
				out.append(end).append(" ");
			}
			out.append("\n");
		}
		
		System.out.println(out);
	}
	
}
