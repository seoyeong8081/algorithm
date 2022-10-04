package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방2 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		int N;
		int[][] arr;
		
		String str;
		StringTokenizer st;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int[][] ansRemember;
		int roomNum, max;
		
		int numVisit = 0;
		int nextR = 0;
		int nextC = 0;
		int curR = 0;
		int curC = 0;
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			ansRemember = new int[N][N];
			max = Integer.MIN_VALUE;
			roomNum = Integer.MAX_VALUE;
			
			for (int row = 0; row < N; row++) {
				str = in.readLine();
				st = new StringTokenizer(str);
				for (int col = 0; col < N; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
//					ansTmp[row][col] = 0;
				}
			}
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					curR = row;
					curC = col;
					numVisit = 1;
					
					Loop: while (true) {
						for (int i = 0; i < dr.length; i++) {
							nextR = curR + dr[i];
							nextC = curC + dc[i];
							if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && arr[nextR][nextC] == arr[curR][curC] + 1) {
								if (ansRemember[nextR][nextC] == 0) {
									curR = nextR;
									curC = nextC;
									numVisit++;
									continue Loop;
								}
								
								ansRemember[row][col] = numVisit + ansRemember[nextR][nextC];
								if (ansRemember[row][col] > max) {
									max = ansRemember[row][col];
									roomNum = arr[row][col];
								} else if (ansRemember[row][col] == max) {
									if (arr[row][col] < roomNum)
										roomNum = arr[row][col];
								}
								break Loop;
								
							}
						}
						ansRemember[row][col] = numVisit;
						if (ansRemember[row][col] > max) {
							max = ansRemember[row][col];
							roomNum = arr[row][col];
						} else if (ansRemember[row][col] == max) {
							if (arr[row][col] < roomNum)
								roomNum = arr[row][col];
						}
						
						break;
					}
					
					
				}
			}
			
//			for (int i = 0; i < N; i++) { //test
//				System.out.println(Arrays.toString(ansRemember[i]));
//			}
			
			
			out.append("#").append(tc).append(" ").append(roomNum).append(" ").append(max).append("\n");
			
		}
		
		System.out.println(out);
		
	}
		
}


