package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int[][] map = new int[N][N];
		boolean[][] isVisited = new boolean[N][N];
		StringTokenizer st;
		Deque<Integer> sharkR = new ArrayDeque<Integer>();
		Deque<Integer> sharkC = new ArrayDeque<Integer>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					isVisited[i][j] = true;
					sharkR.add(i);
					sharkC.add(j);
					map[i][j] = 0; //9 없애버리기 길막하니까
				}
			}
		}
		
		int sharkSize = 2;
		int eatNum = 0;
		int ans = 0;
		
		int[] dr = {-1, 0, 0, 1}; // 상좌 먼저
		int[] dc = {0, -1, 1, 0};
		
		int qSize;
		int curR, curC;
		int nextR, nextC;
		int next;
		int dep = 0;;
		
		while(!sharkR.isEmpty()) {
			qSize = sharkR.size();
			dep++;
			
			System.out.println(sharkR); //test
			System.out.println(sharkC);
			System.out.println(ans);
			
			sameB : while(qSize != 0) {
				curR = sharkR.poll();
				curC = sharkC.poll();
				qSize--;
				
				for (int i = 0; i < 4; i++) {
					nextR = curR + dr[i];
					nextC = curC + dc[i];
					
					if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && map[nextR][nextC] <= sharkSize && !isVisited[nextR][nextC]) {
						next = map[nextR][nextC];
						if (next > 0 && next < sharkSize) {
							// 예외처리
							if (i == 3) {
								if (sharkR.size() > 0 && sharkR.peek() < nextR) {
									int tmpR = sharkR.peek();
									int tmpC = sharkC.peek() + 1;
//									nextR = sharkR.poll();
//									nextC = sharkC.poll() + 1;
									if (tmpC > curC + 2 && tmpC >= 0 && tmpC < N && map[tmpR][tmpC] < sharkSize && map[tmpR][tmpC] > 0 && !isVisited[nextR][nextC]) {
										nextR = sharkR.poll();
										nextC = sharkC.poll() + 1;
									}
								}
							}
							
							//isVisited 초기화 queue 초기화 queue에 다음 위치만 넣고 다시 시작
							for (int row = 0; row < N; row++) {
								for (int col = 0; col < N; col++) {
									isVisited[row][col] = false;
								}
							}
							
							sharkR.clear();
							sharkC.clear();
							
							sharkR.add(nextR);
							sharkC.add(nextC);
							isVisited[nextR][nextC] = true;
							
							ans += dep;
							dep = 0;
							map[nextR][nextC] = 0;
							if (++eatNum == sharkSize) {
								sharkSize++;
								eatNum = 0;
							}
							
//							System.out.println(nextR + ", " + nextC); //test
							
							break sameB;
						}
						isVisited[nextR][nextC] = true;
						
						if (i == 2) { // 오른쪽 넣을때 이전께 아래에 있으면 위치 바꿔주기 // 얘도 C+1로 넣어주는 건가??? dep처리를 잘못?
							if (sharkR.size() > 0 && sharkR.peekFirst() > nextR) {
								int tmpR = sharkR.pollFirst();
								int tmpC = sharkC.pollFirst();
								sharkR.add(nextR);
								sharkC.add(nextC);
								sharkR.add(tmpR);
								sharkC.add(tmpC);
//								dep++;
							}
						}
						
						sharkR.add(nextR);
						sharkC.add(nextC);
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
}
