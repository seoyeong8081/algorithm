package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	
	public static int L, C;

	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder out = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		char[] inputs = new char[C];
		for (int i = 0; i < C; i++) {
			inputs[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(inputs);
		combination(inputs, 0, 0, 0, 0, "");
	}
	
	public static void combination(char[] inputs, int cnt, int start, int vowelCnt, int consonantCnt, String password) {
		if (cnt == L) {
			if (vowelCnt > 0 && consonantCnt > 1) {
				System.out.println(password);
//				System.out.println("vowelCnt: " + vowelCnt + ", consonantCnt: " + consonantCnt);
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			char cur = inputs[i];
			if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
				combination(inputs, cnt + 1, i + 1, vowelCnt + 1, consonantCnt, password + cur);
			} else {
				combination(inputs, cnt + 1, i + 1, vowelCnt, consonantCnt + 1, password + cur);
			}
		}
	}
	
}
