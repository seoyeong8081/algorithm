package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		int N;
		int[][] arr;
		
		String str;
		StringTokenizer st;
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			ansTmp = new int[N][N];
			
			for (int row = 0; row < N; row++) {
				str = in.readLine();
				st = new StringTokenizer(str);
				for (int col = 0; col < N; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
					ansTmp[row][col] = 0;
				}
			}
			roomNum = 0;
			max = 0;
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					roomVisit(arr, row, col, 1, N, row, col);
				}
			}
			
//			for (int row = 0; row < N; row++) {
//				for (int col = 0; col < N; col++) {
//					if (ansTmp[row][col] > max) {
//						roomNum = arr[row][col];
//						max = ansTmp[row][col];
//					} else if (ansTmp[row][col] == max & arr[row][col] < roomNum) {
//						roomNum = arr[row][col];
//					}
//				}
//			}
			
			out.append("#").append(tc).append(" ").append(roomNum).append(" ").append(max).append("\n");
			
		}
		
		System.out.println(out);
		
	}
	
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] ansTmp;
	static int roomNum, max;
	
	public static void roomVisit(int[][] arr, int row, int col, int cntVisit, int N, int startRow, int startCol) {
		
		
		for (int i = 0; i < 4; i++) {
			int rowNext = row + dr[i];
			int colNext = col + dc[i];
			
			if ((rowNext >= 0) && (rowNext < N) && (colNext >= 0) && (colNext < N) && (arr[rowNext][colNext] == arr[row][col] + 1)) {
				if (ansTmp[rowNext][colNext] == 0) {
					roomVisit(arr, rowNext, colNext, cntVisit + 1, N, startRow, startCol);
					break;
				} else {
					ansTmp[startRow][startCol] = ansTmp[rowNext][colNext] + 1;
					if (ansTmp[startRow][startCol] > max) {
						roomNum = arr[startRow][startCol];
						max = ansTmp[startRow][startCol];
					} else if (ansTmp[startRow][startCol] == max & arr[startRow][startCol] < roomNum) {
						roomNum = arr[startRow][startCol];
					}
					return;
				}
			} else {
				if (i == 3 && ansTmp[startRow][startCol] == 0) {
					ansTmp[startRow][startCol] = cntVisit;
					if (ansTmp[startRow][startCol] > max) {
						roomNum = arr[startRow][startCol];
						max = ansTmp[startRow][startCol];
					} else if (ansTmp[startRow][startCol] == max & arr[startRow][startCol] < roomNum) {
						roomNum = arr[startRow][startCol];
					}
				}
				else 
					continue;
			}
		}
		
		
		
	}

}
