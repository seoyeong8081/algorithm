package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합2 {
	
	static int M = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		int N, R, Rcalc;
		long ans;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			Rcalc = Math.min(R, N - R);
			
			ans = 1;
			for (int i = 0; i < Rcalc; i++) {
				ans = (ans * N--) % M;
			}
			
			// 페르마 소정리 여기서 써야할 듯 이전값이 나머지라서 나누어떨어지지 않음
			int divisor = 1;
			for (int i = 2; i <= Rcalc; i++) {
//				ans = (ans / i) % M;
				divisor = (divisor * i) % M;
			}
			
			ans = (ans * pow(divisor, M - 2)) % M;
			
			out.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(out);
	}
	
	private static int pow(long x, int y) {
		long val = 1;
		
		
		while (y > 0) {
//			System.out.println("x: " + x + ", y: " + y + ", val: " + val);
			if (y % 2 == 1) {
				val = (val * x) % M;
				y--;
			}
			x *= x;
			x %= M;
			y /= 2;
		}
		
		return (int)val;
	}
	
}
