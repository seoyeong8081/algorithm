package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("src\\com\\ssafy\\swea\\input_1208.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int tc = 10;
		int width = 100;
		int[] arr = new int[100];
		int dump = 0;
		String line = "";
		int max = 0;
		int max_idx = -1;
		int min = 0;
		int min_idx = -1;
		for (int i = 0; i < tc; i++) {
			out.append("#").append(i+1).append(" ");
			dump = Integer.parseInt(in.readLine());
			line = in.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for (int j = 0; j < width; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int j = 0;
			for (j = 0; j < dump; j++) {
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				for (int k = 0; k < width; k++) {
					if (arr[k] > max) {
						max = arr[k];
						max_idx = k;
					}
					if (arr[k] < min) {
						min = arr[k];
						min_idx = k;
					}
				}
				if (max - min <= 1) {
					out.append(max-min).append("\n");
					break;
				}
				arr[max_idx] -= 1;
				arr[min_idx] += 1;
			}
			
			if (j == dump) {
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				for (int k = 0; k < width; k++) {
					if (arr[k] > max) {
						max = arr[k];
					}
					if (arr[k] < min) {
						min = arr[k];
					}
				}
				out.append(max-min).append("\n");
			}
		}
		System.out.println(out);
		in.close();
	}
	
}
