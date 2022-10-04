package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683_감시 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		List<int[]> cctv1 = new ArrayList<>();
		List<int[]> cctv2 = new ArrayList<>();
		List<int[]> cctv3 = new ArrayList<>();
		List<int[]> cctv4 = new ArrayList<>();
		List<int[]> cctv5 = new ArrayList<>();
		
		
		int mapEle = 0;
		// map 입력받고 cctv 위치 리스트에 넣어주기
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(in.readLine());
			for (int col = 0; col < M; col++) {
				mapEle = Integer.parseInt(st.nextToken());
				map[row][col] = mapEle;
				
				switch (mapEle) {
				case 0:
					break;
				case 6:
					break;
				case 1:
					int[] xy1 = {row, col};
					cctv1.add(xy1);
					break;
				case 2:
					int[] xy2 = {row, col};
					cctv2.add(xy2);
					break;
				case 3:
					int[] xy3 = {row, col};
					cctv3.add(xy3);
					break;
				case 4:
					int[] xy4 = {row, col};
					cctv4.add(xy4);
					break;
				case 5:
//					int[] xy5 = {row, col};
//					cctv5.add(xy5);
					upWatch(map, row, col, N, M);
					downWatch(map, row, col, N, M);
					leftWatch(map, row, col, N, M);
					rightWatch(map, row, col, N, M);
					break;

				default:
					break;
				}
			}
		}
		
		
	}
	
	public static int upWatch(int[][] map, int r, int c, int N, int M) {
		int numWatch = 0;
//		int dr = -1;
//		int dc = 0;
		int curR = r;
		int curC = c;
//		while (curR >= 0 && curR < N && curC >= 0 && curC < M && map[curR][curC] != 6) {
		while (curR >= 0 && map[curR][curC] != 6) {
			if (map[curR][curC] == 0)
				numWatch++;
			map[curR--][curC] = -1;
		}
		
		return numWatch;
	}
	
	public static int upWatchCount(int[][] map, int r, int c, int N, int M) {
		int numWatch = 0;
		int curR = r;
		int curC = c;
		while (curR >= 0 && map[curR][curC] != 6) {
			if (map[curR][curC] == 0)
				numWatch++;
		}
		
		return numWatch;
	}
	
	public static int downWatch(int[][] map, int r, int c, int N, int M) {
		int numWatch = 0;
		int curR = r;
		int curC = c;
		while (curR < N && map[curR][curC] != 6) {
			if (map[curR][curC] == 0)
				numWatch++;
			map[curR++][curC] = -1;
		}
		
		return numWatch;
	}
	
	public static int downWatchCount(int[][] map, int r, int c, int N, int M) {
		int numWatch = 0;
		int curR = r;
		int curC = c;
		while (curR < N && map[curR][curC] != 6) {
			if (map[curR][curC] == 0)
				numWatch++;
		}
		
		return numWatch;
	}
	
	public static int leftWatch(int[][] map, int r, int c, int N, int M) {
		int numWatch = 0;
		int curR = r;
		int curC = c;
		while (curC >= 0 && map[curR][curC] != 6) {
			if (map[curR][curC] == 0)
				numWatch++;
			map[curR][curC--] = -1;
		}
		
		return numWatch;
	}
	
	public static int leftWatchCount(int[][] map, int r, int c, int N, int M) {
		int numWatch = 0;
		int curR = r;
		int curC = c;
		while (curC >= 0 && map[curR][curC] != 6) {
			if (map[curR][curC] == 0)
				numWatch++;
		}
		
		return numWatch;
	}
	
	public static int rightWatch(int[][] map, int r, int c, int N, int M) {
		int numWatch = 0;
		int curR = r;
		int curC = c;
		while (curC < M && map[curR][curC] != 6) {
			if (map[curR][curC] == 0)
				numWatch++;
			map[curR][curC++] = -1;
		}
		
		return numWatch;
	}
	
	public static int rightWatchCount(int[][] map, int r, int c, int N, int M) {
		int numWatch = 0;
		int curR = r;
		int curC = c;
		while (curC < M && map[curR][curC] != 6) {
			if (map[curR][curC] == 0)
				numWatch++;
		}
		
		return numWatch;
	}
}