package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream(new File("src\\com\\ssafy\\swea\\input_1233.txt")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int N;
		String str;
		StringTokenizer st;
		String data;
		boolean isFalse;
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(in.readLine());
			out.append("#").append(tc).append(" ");
			isFalse = false;
			int i = 0;
			
			for (; i < N; i++) {
				str = in.readLine();
				st = new StringTokenizer(str);
				st.nextToken();
				data = st.nextToken();
				if (st.countTokens() == 2) {
					if ((!data.equals("+")) && (!data.equals("-")) && (!data.equals("*")) && (!data.equals("/"))) {
						out.append(0);
						isFalse = true;
						break;
					}
				} else if (st.countTokens() == 0){
					if ((data.equals("+")) || (data.equals("-")) || (data.equals("*")) || (data.equals("/"))) {
						out.append(0);
						isFalse = true;
						break;
					}
				} else {
					out.append(0);
					isFalse = true;
					break;
				}
			}
			
			if (isFalse) {
				i++;
				for (; i < N; i++) {
					in.readLine();
				}
			} else {				
				out.append(1);
			}
			out.append("\n");
			
		}
		
		System.out.println(out);
		
	}

}
