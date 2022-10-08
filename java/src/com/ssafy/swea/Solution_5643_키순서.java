package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {
	
	static int ans;
	static List<Integer>[] big;
	static List<Integer>[] small;
	static int N;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		
		int M;
		int a, b;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());

			big = new List[N];
			small = new List[N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				a = Integer.parseInt(st.nextToken()) - 1;
				b = Integer.parseInt(st.nextToken()) - 1;
				if (big[a] == null) big[a] = new ArrayList<Integer>();
				if (small[b] == null) small[b] = new ArrayList<Integer>();
				big[a].add(b);
				small[b].add(a);
			}
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				check(i);
			}
			out.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(out);
	}

	private static void check(int i) {
		boolean isVisited[] = new boolean[N];
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(i);
		isVisited[i] = true;
		
		int cur;
		while (!que.isEmpty()) {
			cur = que.poll();
			if (big[cur] != null) {
				for (int next : big[cur]) {
					if (isVisited[next]) continue;
					que.offer(next);
					isVisited[next] = true;
				}
			}
		}
		
		que.offer(i);
		while (!que.isEmpty()) {
			cur = que.poll();
			if (small[cur] != null) {
				for (int next : small[cur]) {
					if (isVisited[next]) continue;
					que.offer(next);
					isVisited[next] = true;
				}
			}
		}
		
		boolean check = true;
		for (int idx = 0; idx < N; idx++) {
			if (!isVisited[idx]) {
				check = false;
				break;
			}
		}
		if (check) ans++;
	}
	
}
