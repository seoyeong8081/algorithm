package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {

	static int[] dr_monkey = {-1, 1, 0, 0};
	static int[] dc_monkey = {0, 0, -1, 1};
	static int[] dr_horse = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dc_horse = {-1, 1, -2, 2, -2, 2, -1, 1};
	static int[][] map;
	static boolean[][][] isVisited;
	static int K;
	static int W, H;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		isVisited = new boolean[H][W][32];
		
		if (W == 1 && H == 1) {
			System.out.println(0);
			return;
		}
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		Queue<Integer> pos_r = new ArrayDeque<>();
		Queue<Integer> pos_c = new ArrayDeque<>();
		Queue<Integer> horse_cnt = new ArrayDeque<>();
		
		pos_r.offer(0);
		pos_c.offer(0);
		horse_cnt.offer(0);
		isVisited[0][0][0] = true;
		
		int ans = 0;
		
		while (!pos_r.isEmpty()) {
//			//debug
//			System.out.println("==================");
//			System.out.println(pos_r.toString());
//			System.out.println(pos_c.toString());
//			System.out.println(horse_cnt.toString());
//			//
			
			int breath = pos_r.size();
			ans++;
			
			while (breath != 0) {
				breath--;
				int cr = pos_r.poll();
				int cc = pos_c.poll();
				int chc = horse_cnt.poll();
				
				for (int i = 0; i < dr_monkey.length; i++) {
					int nr = cr + dr_monkey[i];
					int nc = cc + dc_monkey[i];
					
//					if (nr == 1 && nc == 3) {System.out.println("HI");
//					System.out.println((nr < 0 ? "true" : "false"));
//					System.out.println((nr >= H ? "true" : "false"));
//					System.out.println((nc < 0 ? "true" : "false"));
//					System.out.println((nc >= W ? "true" : "false"));
//					System.out.println((map[nr][nc] == 1 ? "true" : "false"));
//					System.out.println((isVisited[nr][nc][chc] ? "true" : "false"));
//					}
					if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1 || isVisited[nr][nc][chc]) continue;
					if (nr == H - 1 && nc == W - 1) {
						System.out.println(ans);
						return;
					}
					pos_r.offer(nr);
					pos_c.offer(nc);
					horse_cnt.offer(chc);
					isVisited[nr][nc][chc] = true;
				}
				
				for (int i = 0; i < dr_horse.length; i++) {
					int nr = cr + dr_horse[i];
					int nc = cc + dc_horse[i];
					if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1 || isVisited[nr][nc][chc + 1] || chc >= K) continue;
					if (nr == H - 1 && nc == W - 1) {
						System.out.println(ans);
						return;
					}
					pos_r.offer(nr);
					pos_c.offer(nc);
					horse_cnt.offer(chc + 1);
					isVisited[nr][nc][chc + 1] = true;
				}
				
//				//debug
//				System.out.println(pos_r.toString());
//				System.out.println(pos_c.toString());
//				System.out.println(horse_cnt.toString());
			}
			
		}
		
		System.out.println(-1);
		
	}
	
}
