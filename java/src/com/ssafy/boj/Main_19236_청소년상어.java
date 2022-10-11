package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19236_청소년상어 {
	
	// 1번이 맨 위 그 다음부터 45도씩 회전
	static int dr[] = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	
	static int sharkNum = 20;
	
	static int map[][];
	static int dir[][];
	static int fishR[] = new int[17];
	static int fishC[] = new int[17];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[4][4];
		dir = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 4; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dir[i][j] = Integer.parseInt(st.nextToken());
				fishR[map[i][j]] = i;
				fishC[map[i][j]] = j;
 			}
		}
		
		sharkNum = 20;
		int firstFish = map[0][0];
		fishR[firstFish] = -1;
		fishC[firstFish] = -1;
		map[0][0] = sharkNum;
		
		moveFishes();
		
		dfs(firstFish);
		
		System.out.println(maxNum);
		
	}

	private static void moveFishes() {
		int r, c, nr, nc;
		for (int i = 1; i < 17; i++) {
			if (fishR[i] == -1) continue; // 먹힌 물고기는 패스
			r = fishR[i];
			c = fishC[i];
			
			nr = r + dr[dir[r][c]];
			nc = c + dc[dir[r][c]];
			int cnt = 0;
			while (cnt < 8 && (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || map[nr][nc] == sharkNum)) {
				cnt++;
				dir[r][c] = (dir[r][c] % 8) + 1;
				nr = r + dr[dir[r][c]];
				nc = c + dc[dir[r][c]];
			}
			
			if (cnt != 8) swap(r, c, nr, nc);
		}
		
	}

	private static void swap(int r, int c, int nr, int nc) {
		// map, dir, fishR, fishC 바꾸기
		// map[nr][nc]가 0일 대는?
		int tempMap = map[r][c];
		int tempDir= dir[r][c];
		map[r][c] = map[nr][nc];
		dir[r][c] = dir[nr][nc];
		map[nr][nc]= tempMap;
		dir[nr][nc] = tempDir;
		if (map[r][c] != 0) {
			fishR[map[r][c]] = r;
			fishC[map[r][c]] = c;
		}
		fishR[map[nr][nc]] = nr;
		fishC[map[nr][nc]] = nc;
	}
	
	static int maxNum = 0;
	
	private static void dfs(int cnt) {
		
		
		int sharkR = fishR[0];
		int sharkC = fishC[0];
		int nr, nc;
		int dirR = dr[dir[sharkR][sharkC]];
		int dirC = dc[dir[sharkR][sharkC]];
		nr = sharkR + dirR;
		nc = sharkC + dirC;
		
		
		
		int fishSize = 0;
		while (nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
			if (map[nr][nc] == 0) {
				nr += dirR;
				nc += dirC;
				continue;
			}
			
			
			fishSize = map[nr][nc];
			
			int[][] mapCopy = new int[4][4];
			int[][] dirCopy = new int[4][4];
			int[] sharkRCopy = new int[17];
			int[] sharkCCopy = new int[17];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					mapCopy[i][j] = map[i][j];
					dirCopy[i][j] = dir[i][j];
				}
			}
			for (int i = 0; i < 17; i++) {
				sharkRCopy[i] = fishR[i];
				sharkCCopy[i] = fishC[i];
			}
			
			fishR[fishSize] = -1;
			fishC[fishSize] = -1;
			map[nr][nc] = sharkNum;
			map[sharkR][sharkC] = 0;
			fishR[0] = nr;
			fishC[0] = nc;
			
			moveFishes();
			dfs(cnt + fishSize);
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					map[i][j] = mapCopy[i][j];
					dir[i][j] = dirCopy[i][j];
				}
			}
			for (int i = 0; i < 17; i++) {
				fishR[i] = sharkRCopy[i];
				fishC[i] = sharkCCopy[i];
			}
			
			nr += dirR;
			nc += dirC;
		}
		
		if (fishSize == 0) {
			// maxNum 업데이트
			if (cnt > maxNum) {
				maxNum = cnt;
			}
		}
	}
}
