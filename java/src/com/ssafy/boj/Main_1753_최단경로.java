package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {

	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

	}
	
	static class Vertex {
		int vertex, weight;

		public Vertex(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine());

		Node[] adjList = new Node[V + 1];

		int from, to, weight;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		int[] D = new int[V + 1]; // 현재 리스트에 있는 것까지 고려했을 때 최소경로
		boolean[] isVisited = new boolean[V + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		
//		PriorityQueue<Vertex> pQueue = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
//		pQueue.add(new Vertex(K, 0));
		D[K] = 0;
		
		int cnt = 0;
		int minIdx, minD;
		while (true) {
			// 현재 D 배열에서 최소인 idx 찾기
			minD = Integer.MAX_VALUE;
			minIdx = -1; // 0으로 바꾸면 맞음 ?????????
			for (int i = 1; i <= V; i++) {
				if (!isVisited[i] && D[i] < minD) {
					minD = D[i];
					minIdx = i;
				}
			}
			
			// 최소인 idx 방문
			if (++cnt == V) break;
			isVisited[minIdx] = true;
			
			// 최소인 idx에 인접한 애들 D 갱신
			for (Node tmp = adjList[minIdx]; tmp != null; tmp = tmp.next) {
				if (!isVisited[tmp.vertex] && D[tmp.vertex] > D[minIdx] + tmp.weight) {
					D[tmp.vertex] = D[minIdx] + tmp.weight;
				}
			}
			
		}
		
		for (int i = 1; i <= V; i++) {
			if (D[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(D[i]);
			}
		}
	}

}
