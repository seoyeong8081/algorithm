package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		boolean[][] isVisitedHedge = new boolean[R][C];

		Queue<Integer> waterR = new ArrayDeque<>();
		Queue<Integer> waterC = new ArrayDeque<>();
		Queue<Integer> hedgeR = new ArrayDeque<>();
		Queue<Integer> hedgeC = new ArrayDeque<>();
		
		String input;
		
		for (int row = 0; row < R; row++) {
			input = in.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = input.charAt(col);
				
				switch (map[row][col]) {
				case 'S':
					hedgeR.add(row);
					hedgeC.add(col);
					isVisitedHedge[row][col] = true;
					break;
				case '*':
					waterR.add(row);
					waterC.add(col);
					break;

				default:
					break;
				}
			}
		}
		
		
		//BFS 물 먼저 그 다음 고슴도치
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int curR, curC;
		int nextR, nextC;
		int sizeW = 0;
		int sizeH = 0;
		int cnt = 0;
		while(!hedgeR.isEmpty()) { // 반복문 조건은 고슴도치가 갈 곳이 있을 때까지
			sizeW = waterR.size();
			while (sizeW != 0) {
				curR = waterR.poll();
				curC = waterC.poll();
				sizeW--;
				
				for (int i = 0; i < 4; i++) { // 상하좌우 탐색
					nextR = curR + dr[i];
					nextC = curC + dc[i];
					
					if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C 
							&& (map[nextR][nextC] == '.' || map[nextR][nextC] == 'S')) { // 그러면 S가 잡아먹히는데 // 잡아먹혀도 현재 위치 정보는 큐에 있으니까 상관없지않나
						map[nextR][nextC] = '*';
						waterR.add(nextR);
						waterC.add(nextC);
					}
				}
			}
			
			sizeH = hedgeR.size();
			cnt++;
			while (sizeH != 0) {
				curR = hedgeR.poll();
				curC = hedgeC.poll();
				sizeH--;
				
				for (int i = 0; i < 4; i++) { // 상하좌우 탐색
					nextR = curR + dr[i];
					nextC = curC + dc[i];
					
					if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C 
							&& (map[nextR][nextC] == '.' || map[nextR][nextC] == 'D') && !isVisitedHedge[nextR][nextC]) { //Visited 체크해야하나? 되돌아가도 상관없지않나?
						if (map[nextR][nextC] == 'D') {
							System.out.println(cnt);
							return;
						}
						isVisitedHedge[nextR][nextC] = true;
						hedgeR.add(nextR);
						hedgeC.add(nextC);
					}
				}
			}
			
		}
		
		System.out.println("KAKTUS");
		
	}


	
}
