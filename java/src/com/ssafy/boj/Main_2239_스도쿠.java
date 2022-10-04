package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2239_스도쿠 {
	
	static int map[][] = new int[9][9];
	static boolean row[][] = new boolean[9][10];
	static boolean col[][] = new boolean[9][10];
	static boolean rect[][] = new boolean[9][10];
	
	private static int rectCal(int r, int c) {
		return (r / 3) * 3 + (c / 3);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input;
		for (int i = 0; i < 9; i++) {
			input = in.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = input.charAt(j) - '0';
				if (map[i][j] != 0) {
					row[i][map[i][j]] = true;
					col[j][map[i][j]] = true;
					rect[rectCal(i, j)][map[i][j]] = true;
				}
			}
		}
		go(0);
//		print();
	}
	
	private static boolean go(int i) {
		if (i == 81) {
			print();
			System.exit(0);
			return true;
		}
		
		
		int r = i / 9;
		int c = i % 9;
		if (map[r][c] != 0) {
			return go(i + 1);
		} else {
			for (int test = 1; test <10; test++) {
				if (!row[r][test] && !col[c][test] && !rect[rectCal(r, c)][test]) {
					map[r][c] = test;
					row[r][test] = true;
					col[c][test] = true;
					rect[rectCal(r, c)][test] = true;
					go(i + 1);
					map[r][c] = 0;
					row[r][test] = false;
					col[c][test] = false;
					rect[rectCal(r, c)][test] = false;
				}
			}
		}
		return false;
	}

	private static void print() {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				out.append(map[i][j]);
			}
			out.append("\n");
		}
		System.out.println(out);
	}

}
