package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		List<Integer> gyu = new ArrayList<>();
		List<Integer> me = new ArrayList<>();
		String str = "";
		StringTokenizer st;
		boolean[] check = new boolean[19];
		int idx, input;
		
		for (int tc = 0; tc < T; tc++) {
			win = 0;
			lose = 0;
			totalCnt = 0;
			str = in.readLine();
			st = new StringTokenizer(str);
			for (idx = 0; idx < 19; idx++) {
				check[idx] = false;
			}
			for (idx = 0; idx < 9; idx++) {
				input = Integer.parseInt(st.nextToken());
				check[input] = true;
				gyu.add(input);
			}
			for (idx = 1; idx <= 18; idx++) {
				if (!check[idx])
					me.add(idx);
			}
			
			fact(gyu, me, 0, 0, 0, new boolean[9]);
			
			
			gyu.clear();
			me.clear();
			
			out.append("#").append(tc+1).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		
		System.out.println(out);
		
	}
	
	public static int win, lose;
	public static int totalCnt;
	
	
	public static void fact(List<Integer> gyu, List<Integer> me, int cnt, int mySum, int gyuSum, boolean[] isSelected) {
		if (cnt == 9) {
			if (mySum > gyuSum)
				lose++;
			else if (mySum < gyuSum)
				win++;
			totalCnt++;
			return;
		}
		
		
		for (int i = 0; i < 9; i++) {
			if (!isSelected[i]) {
				int mySumNext = mySum;
				int gyuSumNext = gyuSum;
				isSelected[i] = true;
				if (gyu.get(cnt) > me.get(i)) {
					gyuSumNext += (gyu.get(cnt) + me.get(i));
				} else if (gyu.get(cnt) < me.get(i)) {
					mySumNext += (gyu.get(cnt) + me.get(i));
				}
				fact(gyu, me, cnt + 1, mySumNext, gyuSumNext, isSelected);
				isSelected[i] = false;
			}
		}
		
	}

}
