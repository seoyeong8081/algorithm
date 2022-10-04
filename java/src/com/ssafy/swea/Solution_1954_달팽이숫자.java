package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution_1954_달팽이숫자 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int tc = Integer.parseInt(in.readLine());
		int N = 0;
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		int directionIdx = 0;
		int currentRow = 0;
		int currentCol = 0;
		int nextRow = 0;
		int nextCol = 0;
		int idx = 1;
		int row = 0;
		int col = 0;
		
		for (int i = 0; i < tc; i++) {
			directionIdx = 0;
			currentRow = 0;
			currentCol = 0;
			nextRow = 0;
			nextCol = 0;
			idx = 1;
		
			N = Integer.parseInt(in.readLine());
			int[][] arr = new int[N][N];
			arr[0][0] = idx++;
			
			for (; idx <= N*N; idx++) {
				
				nextRow = currentRow + dr[directionIdx];
				nextCol = currentCol + dc[directionIdx];
				if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N || arr[nextRow][nextCol] != 0) {
					directionIdx = (directionIdx + 1) % 4;
					nextRow = currentRow + dr[directionIdx];
					nextCol = currentCol + dc[directionIdx];
				}
				arr[nextRow][nextCol] = idx;
				currentRow = nextRow;
				currentCol = nextCol;
			}
			
			out.append("#").append(i + 1).append("\n");
			for (row = 0; row < N; row++) {
				for (col = 0; col < N; col++) {
					out.append(arr[row][col]).append(" ");
				}
				out.append("\n");
			}
			
		}
		System.out.println(out);
	}

}
