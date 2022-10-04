package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {
	
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int tc = Integer.parseInt(in.readLine());
		int N, M;
		int[] arr;
		String str;
		StringTokenizer st;
		for (int i = 1; i <= tc; i++) {
			answer = -1;
			str = in.readLine();
			st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			str = in.readLine();
			st = new StringTokenizer(str);
			for (int idx = 0; idx < N; idx++) {
				arr[idx] = Integer.parseInt(st.nextToken());
			}
			
			combTwo(arr, 0, 0, 0, M, new int[2]);
			out.append("#").append(i).append(" ").append(answer);
			out.append("\n");
		}
		System.out.println(out);
	}
	
	
	public static void combTwo(int[] arr, int start, int cnt, int sum, int M, int[] ans) {
		if (cnt == 2) {
			if (sum <= M && sum > answer) {
				answer = sum;
			}
			return;
		}
		
		
		for (int i = start; i < arr.length; i++) {
			ans[cnt] = arr[i];
			combTwo(arr, i+1, cnt+1, sum + arr[i], M, ans);
		}
		
	}

}
