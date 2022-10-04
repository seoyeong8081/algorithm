package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		Queue<Integer> queueR = new ArrayDeque<Integer>();
		Queue<Integer> queueC = new ArrayDeque<Integer>();
		boolean[][] isVisited = new boolean[R][C];
		
		for (int row = 0; row < R; row++) {
			st = new StringTokenizer(in.readLine());
			for (int col = 0; col < C; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				
				if (map[row][col] == 1) {
					isVisited[row][col] = true;
					queueR.add(row);
					queueC.add(col);
				}
			}
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int ans = -1;
		int qSize;
		int curR, curC;
		int nextR, nextC;
		
		while (!queueR.isEmpty()) {
			qSize = queueR.size();
			ans++;
			
//			System.out.println(queueR);
//			System.out.println(queueC);
//			System.out.println(qSize);
			
			while(qSize != 0) {
				curR = queueR.poll();
				curC = queueC.poll();
				map[curR][curC] = 1;
				qSize--;
				
				for (int i = 0; i < 4; i++) {
					nextR = curR + dr[i];
					nextC = curC + dc[i];
					
					if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C 
							&& map[nextR][nextC] == 0 && !isVisited[nextR][nextC]) {
						isVisited[nextR][nextC] = true;
						queueR.add(nextR);
						queueC.add(nextC);
					}
						
				}
			}
		}
		
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (map[row][col] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(ans);
			
	}
	
}
