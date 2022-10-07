package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {
	
//	public static class Node {
//		int bigSize;
//		int smallSize;
//		int[] big;
//		int[] small;
//		
////		Node() {
////			bigSize = 0;
////			smallSize = 0;
////		}
//	}
	// 아니면 from , to 배열 따로따로 linkedlist처럼?

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		
		int N, M;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
//			Node[] nodes = new Node[N];
//			int big[][] = new int[N][M];
//			int small[][] = new int[N][M];
			List[] big = new List[N];
			for (int i = 0; i < N; i++) {
				big[i] = new ArrayList<Integer>();
			}
		}
		System.out.println(out);
	}
	
}
