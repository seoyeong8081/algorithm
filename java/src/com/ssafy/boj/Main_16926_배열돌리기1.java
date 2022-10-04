package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int N, M, R;
		String str;
		StringTokenizer st;
		
		str = in.readLine();
		st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < R; i++) {
			rotateOne(arr, N, M);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				out.append(arr[i][j]).append(" ");
			}
			out.append("\n");
		}
		System.out.println(out);
	}
	
	public static void rotateOne(int[][] arr, int N, int M) {
		int[][] vertex = {{0, 0}, {N - 1, 0}, {N - 1, M - 1}, {0, M - 1}};
		int temp = 0;
		int[] dirX = {1, 0, -1, 0};
		int[] dirY = {0, 1, 0, -1};
		
		
		while ((vertex[0][1] < vertex[3][1]) && (vertex[1][1] < vertex[2][1]) && (vertex[0][0] < vertex[1][0]) && (vertex[3][0] < vertex[2][0])) {
			temp = rotateLine(arr, dirX[0], dirY[0], vertex[0], vertex[1], arr[vertex[0][0]][vertex[0][1]]);
			temp = rotateLine(arr, dirX[1], dirY[1], vertex[1], vertex[2], temp);
			temp = rotateLine(arr, dirX[2], dirY[2], vertex[2], vertex[3], temp);
			temp = rotateLine(arr, dirX[3], dirY[3], vertex[3], vertex[0], temp);
			
			vertex[0][0]++;
			vertex[0][1]++;
			vertex[1][0]--;
			vertex[1][1]++;
			vertex[2][0]--;
			vertex[2][1]--;
			vertex[3][0]++;
			vertex[3][1]--;
		}
	}
	
	public static int rotateLine(int[][] arr, int dirX, int dirY, int[] startVertex, int[] endVertex, int endValue) {
		int tmp = arr[endVertex[0]][endVertex[1]];
		
		if (dirX == 0) {
			for (int i = endVertex[1]; i != startVertex[1]; i = i - dirY) {
				if (i == startVertex[1] + dirY) {
					arr[endVertex[0]][i] = endValue;
				} else {
					arr[endVertex[0]][i] = arr[endVertex[0]][i - dirY];
				}
			}
		}
		if (dirY == 0) {
			for (int i = endVertex[0]; i != startVertex[0]; i = i - dirX) {
				if (i == startVertex[0] + dirX) {
					arr[i][endVertex[1]] = endValue;
				} else {
					arr[i][endVertex[1]] = arr[i - dirX][endVertex[1]];
				}
			}
		}
		
		return tmp;
	}
}
