package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17143_낚시왕2 {
	
	static int[][] map;
	static int[][] sharks;
	static int R, C, M;
	static int ans = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R + 1][C + 1];
		sharks = new int[M + 1][5];
		int r, c, s, d, z;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			sharks[i][0] = r;
			sharks[i][1] = c;
			sharks[i][2] = s;
			sharks[i][3] = d;
			sharks[i][4] = z;
			map[r][c] = i;
		}
		
		for (int i = 1; i <= C; i++) {
			go(i);
		}
		System.out.println(ans);
	}

	private static void go(int col) {
		// 1. 열에 있는 상어 중 가장 가까운 상어 잡기
		fishing(col);
		
		// 2. 상어 이동
		if (col < C) {
			moveSharks();
		}
	}

	private static void moveSharks() {
		map = new int[R + 1][C + 1];
		
		for (int i = 1; i < sharks.length; i++) {
			if (sharks[i][0] != 0) {
				moveShark(i);
			}
		}
		
//		for (int[] sh : shark) { //debugging
//			System.out.println(sh[0] + " " + sh[1] + " " + sh[2] + " " + sh[3] + " " + sh[4]);
//		}
//		System.out.println("=========================================");
		
		// 같은 자리에 여러 마리 있으면 제거하기
		//eatEach();
		
	}

//	private static void eatEach() {
//		//Map<int[], List<int[]>> map = new HashMap<int[], List<int[]>>();
////		Map<int[], PriorityQueue<int[]>> map = new HashMap<int[], PriorityQueue<int[]>>();
////		int size = shark.size();
////		int[] sh;
////		for (int i = 0; i < size; i++) {
////			sh = shark.get(i);
////			int[] key = {sh[0], sh[1]};
////			PriorityQueue<int[]> value = map.get(key);
////			if (value == null) {
////				value = new PriorityQueue<>(new Comparator<int[]>() {
////					@Override
////					public int compare(int[] o1, int[] o2) {
////						return o2[2] - o1[2];
////					}
////				});
////			}
////			value.add(new int[] {sh[2], sh[3], sh[4]});
////			map.put(key, value);
////		}
////		
////		shark.clear();
////		for (int[] key : map.keySet()) {
////			System.out.println("key:" + key[0] + " " + key[1]);
////			int[] value = map.get(key).poll();
////			shark.add(new int[] {key[0], key[1], value[0], value[1], value[2]});
////		}
//		Map<String, PriorityQueue<int[]>> map = new HashMap<String, PriorityQueue<int[]>>();
//		int size = shark.size();
//		int[] sh;
//		for (int i = 0; i < size; i++) {
//			sh = shark.get(i);
//			String key = sh[0] + " " + sh[1];
//			PriorityQueue<int[]> value = map.get(key);
//			if (value == null) {
//				value = new PriorityQueue<>(new Comparator<int[]>() {
//					@Override
//					public int compare(int[] o1, int[] o2) {
//						return o2[2] - o1[2];
//					}
//				});
//			}
//			value.add(new int[] {sh[2], sh[3], sh[4]});
//			map.put(key, value);
//		}
//		
//		shark.clear();
//		for (String key : map.keySet()) {
//			StringTokenizer st = new StringTokenizer(key);
////			int r = Integer.parseInt(st.nextToken());
//			int[] value = map.get(key).poll();
//			shark.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), value[0], value[1], value[2]});
//		}
//	}

	static int[] drArray = {0, -1, 1, 0, 0};
	static int[] dcArray = {0, 0, 0, 1, -1};
	private static void moveShark(int i) {
		int[] sh = sharks[i];
		// r, c, s(속력), d(1:위 2:아래 3:오른쪽 4:왼쪽), z(크기)
		int r = sh[0];
		int c = sh[1];
		int d = sh[3];
		int dr = drArray[d];
		int dc = dcArray[d];
		int s = sh[2];
		// 계산을 수학적으로
		for (int cnt = 0; cnt < s; cnt++) {
			if (r == 1 && d == 1) {
				dr = -dr;
				dc = -dc;
				d = 2;
			} else if (r == R && d == 2) {
				dr = -dr;
				dc = -dc;
				d = 1;
			} else if (c == 1 && d == 4) {
				dr = -dr;
				dc = -dc;
				d = 3;
			} else if (c == C && d == 3) {
				dr = -dr;
				dc = -dc;
				d = 4;
			}
			r += dr;
			c += dc;
		}
//		shark.set(i, new int[] {r, c, s, d, sh[4]});
		// sharks, map 둘다 업데이트 해야함
		if (map[r][c] == 0) {
			map[r][c] = i;
			sharks[i][0] = r;
			sharks[i][1] = c;
			sharks[i][3] = d;
		} else if (sharks[map[r][c]][4] < sharks[i][4]) { // 원래 있던 놈 잡아먹음
			sharks[map[r][c]][0] = 0;
			map[r][c] = i;
			sharks[i][0] = r;
			sharks[i][1] = c;
			sharks[i][3] = d;
		} else if (sharks[map[r][c]][4] > sharks[i][4]) { // 내가 잡아먹힘
			sharks[i][0] = 0;
		}
	}

	private static void fishing(int col) {
		for (int i = 1; i <= R; i++) {
			if (map[i][col] > 0) {
				ans += sharks[map[i][col]][4]; // 잡아먹힌 상어
				sharks[map[i][col]][0] = 0; // 잡아먹힌 상어
				map[i][col] = 0;
				break;
			}
		}
	}
	
}
