package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		List<Integer> list = new LinkedList<>();
		int N;
		String str = "";
		StringTokenizer st;
		int commandNum;
		int x, y;
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(in.readLine());
			str = in.readLine();
			st = new StringTokenizer(str);
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			commandNum = Integer.parseInt(in.readLine());
			str = in.readLine();
			st = new StringTokenizer(str);
			for (int i = 0; i < commandNum; i++) {
				st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				for (int putCnt = 0; putCnt < y; putCnt++) {
					list.add(x+putCnt, Integer.parseInt(st.nextToken()));
				}
			}
			
			out.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) {
				out.append(list.get(i)).append(" ");
			}
			out.append("\n");
			list.clear();
		}
		
		System.out.println(out);
	}
}
