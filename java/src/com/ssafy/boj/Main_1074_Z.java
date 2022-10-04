package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	
	public static int r, c;
//	public static int ans;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		findVisitTime(0, 0, (int)Math.pow(2, N), 0);
	}
	
	public static void findVisitTime(int startR, int startC, int len, int startVisit) {
		if (len == 1) {
			System.out.println(startVisit);
			return;
		}
		
//		System.out.println("startR: " + startR + ", startc: " + startC + ", len: " + len + ", startVisit: " + startVisit );
		int halfR = startR + len / 2;
		int halfC = startC + len / 2;
		if (r < halfR) {
			if (c < halfC) {
//				System.out.println("1번 ");
				findVisitTime(startR, startC, len / 2, startVisit);
			} else {
//				System.out.println("2번 ");
				findVisitTime(startR, halfC, len / 2, startVisit + (len * len / 4));
			}
		} else {
			if (c < halfC) {
//				System.out.println("3번 ");
				findVisitTime(halfR, startC, len / 2, startVisit + (len * len / 2));
			} else {
//				System.out.println("4번 ");
				findVisitTime(halfR, halfC, len / 2, startVisit + (len * len / 4 * 3));
			}
		}
	}
	
}
