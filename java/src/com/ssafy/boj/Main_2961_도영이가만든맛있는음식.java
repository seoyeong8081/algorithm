package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
	
	public static int min = Integer.MAX_VALUE;
	public static int N;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		List<Integer> sour = new ArrayList<Integer>();
		List<Integer> salty = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str);
			sour.add(Integer.parseInt(st.nextToken()));
			salty.add(Integer.parseInt(st.nextToken()));
		}
		
		comb(sour, salty, 1, 0, 0);
		System.out.println(min);
	}
	
	
	
	public static void comb(List<Integer> sour, List<Integer> salty, int curSour, int curSalty, int start) {

		for (int i = start; i < N; i++) {
			int nextSour = curSour * sour.get(i);
			int nextSalty = curSalty + salty.get(i);
			int diff = Math.abs(nextSour - nextSalty);
			
			if (diff < min)
				min = diff;
			comb(sour, salty, nextSour, nextSalty, i + 1);
		}
	}
	
}
