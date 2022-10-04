package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		int K;
		int ans;
//		Deque<Integer> magnet1 = new ArrayDeque<>(); //collection 여러개 똑똑하게 못쓰나??? collection 배열?
//		Deque<Integer> magnet2 = new ArrayDeque<>();
//		Deque<Integer> magnet3 = new ArrayDeque<>();
//		Deque<Integer> magnet4 = new ArrayDeque<>();
		@SuppressWarnings("unchecked")
		Deque<Integer>[] magnet = new ArrayDeque[4]; // 매번 생성하는게 효율이 좋을지도??? 테스트 해보기!!! 훨씬 더 좋음
		
		int num, rotate;
		
		for (int tc = 1; tc <= T; tc++) {
			magnet[0] = new ArrayDeque<Integer>();
			magnet[1] = new ArrayDeque<Integer>();
			magnet[2] = new ArrayDeque<Integer>();
			magnet[3] = new ArrayDeque<Integer>();
			K = Integer.parseInt(in.readLine());
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(in.readLine());
				saveMagnetInfo(magnet[i], st);
			}
//			System.out.println(magnet[0]);
//			System.out.println(magnet[1]);
//			System.out.println(magnet[2]);
//			System.out.println(magnet[3]);

			
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(in.readLine());
				num = Integer.parseInt(st.nextToken());
				rotate = Integer.parseInt(st.nextToken());
				
				boolean check12 = checkPolarity(magnet[0], magnet[1]);
				boolean check23 = checkPolarity(magnet[1], magnet[2]);
				boolean check34 = checkPolarity(magnet[2], magnet[3]);
				
				switch (num) {
				case 1:
					rotate(magnet[0], rotate);
					if (check12) {
						rotate(magnet[1], -rotate);
						if (check23) {
							rotate(magnet[2], rotate);
							if (check34) {
								rotate(magnet[3], -rotate);
							}
						}
					}
					break;
				case 2:
					rotate(magnet[1], rotate);
					if (check12) {
						rotate(magnet[0], -rotate);
					}
					if (check23) {
						rotate(magnet[2], -rotate);
						if (check34) {
							rotate(magnet[3], rotate);
						}
					}
					break;
				case 3:
					rotate(magnet[2], rotate);
					if (check34) {
						rotate(magnet[3], -rotate);
					}
					if (check23) {
						rotate(magnet[1], -rotate);
						if (check12) {
							rotate(magnet[0], rotate);
						}
					}
					break;
				case 4:
					rotate(magnet[3], rotate);
					if (check34) {
						rotate(magnet[2], -rotate);
						if (check23) {
							rotate(magnet[1], rotate);
							if (check12) {
								rotate(magnet[0], -rotate);
							}
						}
					}
					break;

				default:
					break;
				}
				
//				System.out.println(magnet[0]);
//				System.out.println(magnet[1]);
//				System.out.println(magnet[2]);
//				System.out.println(magnet[3]);
			}
			
			ans = magnet[0].peekFirst() + magnet[1].peekFirst() * 2 + magnet[2].peekFirst() * 4 + magnet[3].peekFirst() * 8;
			out.append("#").append(tc).append(" ").append(ans).append("\n");
			
//			System.out.println(magnet[0]);
//			rotate(magnet[0], 1); // 0 0 0 1 0 0 1 0
//			System.out.println(magnet[0]);
//			rotate(magnet[0], -1);
//			System.out.println(magnet[0]);
			
			
//			for (int i = 0; i < 4; i++) {
//				magnet[i].clear();
//			}
		}
		
		System.out.println(out);
	}

	private static void saveMagnetInfo(Deque<Integer> magnet1, StringTokenizer st) {
		for (int i = 0; i < 8; i++) {
			magnet1.addLast(Integer.parseInt(st.nextToken()));
		}
	}
	
	private static boolean checkPolarity(Deque<Integer> magnet1, Deque<Integer> magnet2) {
		int first = (int)magnet1.toArray()[2];
		int second = (int)magnet2.toArray()[6];
		
		if (first == second) {
			return false;
		} else {
			return true;
		}
	}
	
	private static void rotate(Deque<Integer> magnet, int direction) {
		if (direction == -1) { // 반시계방향
			int tmp = magnet.pollFirst();
			magnet.addLast(tmp);
		} else { // 시계방향
			int tmp = magnet.pollLast();
			magnet.addFirst(tmp);
		}
	}
	
}
