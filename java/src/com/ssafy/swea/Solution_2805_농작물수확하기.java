package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("src\\com\\ssafy\\swea\\input_2805.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		StringBuilder out = new StringBuilder();
		int tc = Integer.parseInt(in.readLine());
		int N = 0;
		int ans = 0;
		int count = 1;
		int countIdx = 0;
		int startidx = 0;
		String str = "";
		
		for (int i = 0; i < tc; i++) {
			ans = 0;
			count = 1;
			countIdx = 0;
			out.append("#").append(i+1).append(" ");
			N = Integer.parseInt(in.readLine());
			startidx = (N - 1) / 2;
			
			for (int row = 0; row < N; row++) {
				str = in.readLine();
				for (int col = 0; col < N; col++) {
					if (col >= startidx) {
						ans += str.charAt(col) - '0';
						countIdx++;
					}
					if (countIdx == count) {
						if (row < (N - 1) / 2) {
							startidx--;
							count += 2;
						} else {
							startidx++;
							count -= 2;
						}
						countIdx = 0;
						break;
					}
				}
			}
			
			out.append(ans).append("\n");
		}
		
		in.close();
		System.out.println(out);
	}
	
}
