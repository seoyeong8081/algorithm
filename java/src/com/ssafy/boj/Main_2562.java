package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2562 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[9];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		int ans = arr[0];
		int idx = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > ans) {
				ans = arr[i];
				idx = i + 1;
			}
		}
		
		sb.append(ans).append("\n");
		sb.append(idx);
		System.out.println(sb);
	}

}
