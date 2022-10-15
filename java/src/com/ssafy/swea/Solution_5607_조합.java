package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합 {
	
	static int M = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		int N, R;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			long r1 = 1;
			long r2 = 1;
			
			for (int i = 1; i <= N; i++) {
				r1 = (r1 * i) % M;
			}
			for (int i = 1; i <= R; i++) {
				r2 = (r2 * i) % M;
			}
			for (int i = 1; i <= N-R; i++) {
				r2 = (r2 * i) % M;
			}
			
			r2 = x_y(r2, M - 2) % M;
			r1 = (r1 * r2) % M;
			
			out.append("#").append(tc).append(" ").append(r1).append("\n");
		}
		
		System.out.println(out);
	}
	
	private static long x_y(long x, int y) {
		long xy = 1;
		
		while (y > 0) {
			if (y % 2 == 1) {
				xy = (xy * x) % M;
				y--;
			}
			x *= x;
			x %= M;
			y /= 2;
		}
		
		return xy;
	}
}
