package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		String str;
		StringTokenizer st;
		List<Integer> taste = new ArrayList<Integer>();
		List<Integer> cal = new ArrayList<Integer>();
		
		for (int tc = 0; tc < T; tc++) {
			max = 0;
			str = in.readLine();
			st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			taste.clear();
			cal.clear();
			
			for (int i = 0; i < N; i++) {
				str = in.readLine();
				st = new StringTokenizer(str);
				taste.add(Integer.parseInt(st.nextToken()));
				cal.add(Integer.parseInt(st.nextToken()));
			}
			
			comb(taste, cal, 0, 0, 0);
			
			out.append("#").append(tc + 1).append(" ").append(max).append("\n");
		}
		
		System.out.println(out);
	}
	
	public static int N, L;
	public static int max;
	
	public static void comb(List<Integer> taste, List<Integer> cal, int curTaste, int curCal, int start) {

		
		for (int i = start; i < N; i++) {
			int nextTaste = curTaste + taste.get(i);
			int nextCal = curCal + cal.get(i);
			if (nextCal <= L) {
				if (nextTaste > max)
					max = nextTaste;
				comb(taste, cal, nextTaste, nextCal, i + 1);
			}
		}
	}

}
