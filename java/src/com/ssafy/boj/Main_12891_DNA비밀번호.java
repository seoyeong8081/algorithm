package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {

	public static int answer;
	public static int[] numMore = new int[4];
	public static int S, P;
	public static int[] count = new int[4];
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		StringTokenizer st = new StringTokenizer(input);
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		char[] strArr;
		strArr = in.readLine().toCharArray();
		
		input = in.readLine();
		st = new StringTokenizer(input);
		for (int i = 0; i < numMore.length; i++) {
			numMore[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < P; i++) {
			countPlus(strArr[i]);
		}
		isAnswer();
		for (int i = 1; i <= S - P; i++) {
			countMinus(strArr[i - 1]);
			countPlus(strArr[i - 1 + P]);
			isAnswer();
		}
		
		System.out.println(answer);
	}
	
	public static void isAnswer() {
		if (count[0] < numMore[0] || count[1] < numMore[1] || count[2] < numMore[2] || count[3] < numMore[3])
			return;
		answer++;
	}
	
	public static void countPlus(char ch) {
		switch (ch) {
		case 'A':
			count[0]++;
			break;
		case 'C':
			count[1]++;
			break;
		case 'G':
			count[2]++;
			break;
		case 'T':
			count[3]++;
			break;
		default:
			break;
		}
	}
	
	public static void countMinus(char ch) {
		switch (ch) {
		case 'A':
			count[0]--;
			break;
		case 'C':
			count[1]--;
			break;
		case 'G':
			count[2]--;
			break;
		case 'T':
			count[3]--;
			break;
		default:
			break;
		}
	}
	
}
