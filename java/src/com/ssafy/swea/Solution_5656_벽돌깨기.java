package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	
	static int W, H, N;
	static int map[][];
	static int mapTmp[][];
	static int min;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			mapTmp = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					mapTmp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			min = Integer.MAX_VALUE;
			recursionN(0, new int[N]);
			
			out.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(out);
	}
	


	private static void recursionN(int cnt, int[] cases) {
		if (cnt == N) {
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = mapTmp[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				bomb(cases[i]);
				if (count() == 0) {
					min = 0;
					return;
				}
			}
			min = Math.min(min, count());
			return;
		}
		
		if (min == 0) return;
		
		for (int i = 0; i < W; i++) {
			cases[cnt] = i;
			recursionN(cnt + 1, cases);
		}
	}



	public static void bomb(int pos) {
		for (int i = 0; i < H; i++) {
			if (map[i][pos] != 0) {
				bombBreak(i, pos);
				mapGravity();
				break;
			}
		}
	}
	
	private static void mapGravity() {
		int[] tmp = new int[H];
		int cnt;
		for (int col = 0; col < W; col++) {
			Arrays.fill(tmp, 0);
			cnt = 0;
			for (int row = H - 1; row >= 0; row--) {
				if (map[row][col] != 0) {
					tmp[cnt++] = map[row][col];
				}
			}
			for (int row = H - 1; row >= 0; row--) {
				map[row][col] = tmp[H - 1 - row];
			}
		}
		
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void bombBreak(int r, int c) {
		//끝부터 터뜨리기?
//		System.out.println("(" + r + ", " + c + ")");
		if (map[r][c] == 0) return;
		int d = map[r][c] - 1;
		map[r][c] = 0;
		for (; d > 0; d--) {
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i] * d;
				int nc = c + dc[i] * d;
				if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
				bombBreak(nr, nc);
			}
		}
	}
	
	private static int count() {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0) cnt++;
//				System.out.print(map[i][j] + " ");
			}
//			System.out.println();
		}
		return cnt;
	}
}
