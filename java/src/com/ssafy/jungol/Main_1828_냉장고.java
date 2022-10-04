package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {

	public static class Refrigerator implements Comparable<Refrigerator>{
		public int x; // 최저 보관 온도
		public int y; // 최고 보관 온도

		public Refrigerator(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Refrigerator o) {
			return this.y == o.y ? this.x - o.x : this.y - o.y;
		}

	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		
		Refrigerator[] refs = new Refrigerator[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			refs[i] = new Refrigerator(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(refs);
		
		int cnt = 1;
		Refrigerator current = refs[0];
		for (int i = 1; i < N; i++) {
			if (current.y < refs[i].x) {
				cnt++;
				current = refs[i];
			}
		}
		
		System.out.println(cnt);
	}

}
