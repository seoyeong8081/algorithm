package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		int n, m;
		int op, a, b;
		
		for (int tc = 1; tc <= T; tc++) {
			out.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[] parents = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				op = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				switch (op) {
				case 0:
					union(a, b, parents);
					break;
				case 1:
					out.append(check(a, b, parents));
					break;

				default:
					break;
				}
			}
			
			
			out.append("\n");
		}
		
		System.out.println(out);
	}

	private static boolean union(int a, int b, int[] parents) {
		if (check(a, b, parents) == 1) return false;
		
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
	
	private static int check(int a, int b, int[] parents) {
		int aRoot = find_set(a, parents);
		int bRoot = find_set(b, parents);
		
		if (aRoot == bRoot) return 1;
		else return 0;
	}
	
}
