package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1 {

	public static void main(String[] args) throws IOException {
		int[][] arr = new int[100][100];
		File file = new File("src\\com\\ssafy\\swea\\input_1210.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		StringBuilder out = new StringBuilder();
		String str = "";
		int currentRow = 0;
		int currentCol = 0;
		int nextRow = 0;
		int nextCol = 0;
		int row = 0;
		int col = 0;
		int[] dr = {0, 0, -1};
		int[] dc = {-1, 1, 0};
		int directionIdx = 2;
		
		for (int i = 0; i < 10; i++) {
			//input 받기
			out.append("#").append(Integer.parseInt(in.readLine())).append(" ");
			for (row = 0; row < 100; row++) {
				str = in.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (col = 0; col < 100; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
				}
			}

			
			//도착지점 찾기
			for (col = 0; col < 100; col++) {
				if (arr[99][col] == 2) {
					currentRow = 99;
					currentCol = col;
					break;
				}
			}
			
			//사다리 타기
			while (currentRow > 0) {
				if (directionIdx == 2) {
					for (int dIdx = 0; dIdx < 3; dIdx++) {
						nextRow = currentRow + dr[dIdx];
						nextCol = currentCol + dc[dIdx];
						if (nextRow < 0 || nextRow >= 100 || nextCol < 0 || nextCol >= 100)
							continue;
						if (arr[nextRow][nextCol] == 1) {
							directionIdx = dIdx;
							currentRow = nextRow;
							currentCol = nextCol;
							break;
						}
					}
				} else {
					nextRow = currentRow + dr[directionIdx];
					nextCol = currentCol + dc[directionIdx];
					if (nextRow >= 0 && nextRow < 100 && nextCol >= 0 && nextCol < 100) {
						if (arr[nextRow][nextCol] == 1) {
							currentRow = nextRow;
							currentCol = nextCol;
							continue;
						}
					}
					nextRow = currentRow + dr[2];
					nextCol = currentCol + dc[2];
					if (arr[nextRow][nextCol] == 1) {
						currentRow = nextRow;
						currentCol = nextCol;
						directionIdx = 2;
						continue;
					}
				}
			}
			out.append(currentCol).append("\n");
		}
		
		
		in.close();
		System.out.println(out);
	}
	
}
