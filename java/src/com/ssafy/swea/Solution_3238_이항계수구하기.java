package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2
//7 4 11
//462674874256410 372970000403159 89329

//#1 2
//#2 50871
public class Solution_3238_이항계수구하기 {

	static int p;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		long n, r;
		//long ans;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			n = Long.parseLong(st.nextToken());
			r = Long.parseLong(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			
			
			
			out.append("#").append(tc).append(" ").append(combinationRecursion(n, r)).append("\n");
			
		}
		
		System.out.println(out);
	}
	
	private static long combinationRecursion(long n, long r) {
		if (n < p) return combination(n, r);
		
		long an = n / p;
		long bn = n % p;
		long ar = r / p;
		long br = r % p;
		
		if (bn < br) return 0;
		
		return (combinationRecursion(an, ar) * combination(bn, br)) % p;
	}
	
	private static long combination(long n, long r) {
		int rcalc = (int)Math.min(r, n - r);
		
		long ans = 1;
		for (int i = 0; i < rcalc; i++) {
			ans = (ans * n--) % p;
		}
		
		// 페르마 소정리 여기서 써야할 듯 이전값이 나머지라서 나누어떨어지지 않음
		long divisor = 1;
		for (int i = 2; i <= rcalc; i++) {
//			ans = (ans / i) % M;
			divisor = (divisor * i) % p;
		}
		
		return (ans * pow(divisor, p - 2)) % p;
	}
	

	private static long pow(long x, int y) {
		long val = 1;
		
		while (y > 0) {
			if (y % 2 == 1) {
				val = (val * x) % p;
				y--;
			}
			x = (x * x) % p;
			y /= 2;
		}
		
		return val;
	}
	
}
