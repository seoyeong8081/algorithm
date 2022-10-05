package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다 {

	public static void main(String[] args) throws Exception{
//		System.out.println((int)'.'); //46
//		System.out.println((int)'#'); //35
//		System.out.println((int)'a'); //97
//		System.out.println((int)'A'); //65
//		System.out.println((int)'0'); //48
//		System.out.println((int)'1'); //49
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][M];
		boolean key[] = new boolean[6];
		boolean door[] = new boolean[6];
		
		// queue {r, c, 'a', 'b', 'c', 'd', 'e', 'f'}
		boolean isVisited[][][][][][][][] = new boolean[N][M][2][2][2][2][2][2];
		Queue<int[]> que = new ArrayDeque<>();
		
		String input;
//		int desr = 0; int desc = 0;
		for  (int i = 0; i < N; i++) {
			input = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] >= 97 && map[i][j] < 103) {
					key[map[i][j] - 97] = true;
				} else if (map[i][j] >= 65 && map[i][j] < 71) {
					door[map[i][j] - 65] = true;
				} else if (map[i][j] == '0') {
					que.offer(new int[] {i, j, 0, 0, 0, 0, 0, 0});
					isVisited[i][j][0][0][0][0][0][0] = true;
//				} else if (map[i][j] == '1') {
//					desr = i;
//					desc = j;
				}
			}
		}
		
		// 문 찾았는데 그 맵에 열쇠없으면 못가는거를 코드에 넣어도 되나 안될듯?
		// queue {r, c, 'a', 'b', 'c', 'd', 'e', 'f'}
		int cnt = 0;
		int depth = 0;
		int nr, nc;
		int r, c;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		while (!que.isEmpty()) {
			cnt = que.size();
			depth++;
			while (cnt != 0) {
				cnt--;
				int[] cur = que.poll();
				r = cur[0];
				c = cur[1];
				for (int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#' || isVisited[nr][nc][cur[2]][cur[3]][cur[4]][cur[5]][cur[6]][cur[7]]) continue;
					if (map[nr][nc] == '1') {
						System.out.println(depth);
						return;
					} else if (map[nr][nc] >= 97 && map[nr][nc] < 103) { // key
						if (cur[map[nr][nc] - 95] == 0) {
							cur[map[nr][nc] - 95] = 1;
							que.offer(new int[] {nr, nc, cur[2], cur[3], cur[4], cur[5], cur[6], cur[7]});
							isVisited[nr][nc][cur[2]][cur[3]][cur[4]][cur[5]][cur[6]][cur[7]] = true;
							cur[map[nr][nc] - 95] = 0;
						} else {
							que.offer(new int[] {nr, nc, cur[2], cur[3], cur[4], cur[5], cur[6], cur[7]});
							isVisited[nr][nc][cur[2]][cur[3]][cur[4]][cur[5]][cur[6]][cur[7]] = true;
						}
					} else if (map[nr][nc] >= 65 && map[nr][nc] < 71) { // door
						if (cur[map[nr][nc] - 63] == 1) {
							que.offer(new int[] {nr, nc, cur[2], cur[3], cur[4], cur[5], cur[6], cur[7]});
							isVisited[nr][nc][cur[2]][cur[3]][cur[4]][cur[5]][cur[6]][cur[7]] = true;
						}
					} else {
						que.offer(new int[] {nr, nc, cur[2], cur[3], cur[4], cur[5], cur[6], cur[7]});
						isVisited[nr][nc][cur[2]][cur[3]][cur[4]][cur[5]][cur[6]][cur[7]] = true;
					}
				}
			}
		}
		
		System.out.println(-1);
	}
	
}
