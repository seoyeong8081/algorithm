package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_15170_낚시터자리잡기 {
	
	public static int N; // 5 이상 60 이하
	public static int[] door = new int[3];
	public static int[] angler = new int[3];
	public static int minDis = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc < T; tc++) {
			N = Integer.parseInt(in.readLine());
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(in.readLine());
				door[i] = Integer.parseInt(st.nextToken());
				angler[i] = Integer.parseInt(st.nextToken());
			}
			
			//boolean[] fishing = new boolean[N];
			fill(door[0], door[1], door[2], angler[0], angler[1], angler[2]);
			fill(door[0], door[2], door[1], angler[0], angler[2], angler[1]);
			fill(door[1], door[0], door[2], angler[1], angler[0], angler[2]);
			fill(door[1], door[2], door[0], angler[1], angler[2], angler[0]);
			fill(door[2], door[0], door[1], angler[2], angler[0], angler[1]);
			fill(door[2], door[1], door[0], angler[2], angler[1], angler[0]);
			
		}
	}
	
	public static void fill(int gate1, int gate2, int gate3, int pNum1, int pNum2, int pNum3) {
		for (boolean b1 = true; b1 != false; b1 = false) {
			for (boolean b2 = true; b2 != false; b2 = false) {
				for (boolean b3 = true; b3 != false; b3 = false) {
					minDis = Math.min(minDis, calFill(b1, b2, b3, gate1, gate2, gate3, pNum1, pNum2, pNum3));
				}
			}
		}
	}
	
	public static int calFill(boolean lr1, boolean lr2, boolean lr3, int gate1, int gate2, int gate3, int pNum1, int pNum2, int pNum3) {
		int term1, term2, term3;
		
		if (lr1) {
			term1 = fillLeftFirst(new boolean[N], pNum1, gate1);
		} else {
			term1 = fillRightFirst(new boolean[N], pNum1, gate1);
		}
		if (term1 == Integer.MAX_VALUE) // fillLeftFirst(new boolean[N], pNum1, gate1) 첫번째 계산값이 MAX면 바로 MAX 리턴하게
			return Integer.MAX_VALUE;
		
		if (lr2) {
			term2 = fillLeftFirst(new boolean[N], pNum2, gate2);
		} else {
			term2 = fillRightFirst(new boolean[N], pNum2, gate2);
		}
		if (term2 == Integer.MAX_VALUE) 
			return Integer.MAX_VALUE;
		
		if (lr3) {
			term3 = fillLeftFirst(new boolean[N], pNum3, gate3);
		} else {
			term3 = fillRightFirst(new boolean[N], pNum3, gate3);
		}
		if (term3 == Integer.MAX_VALUE) 
			return Integer.MAX_VALUE;
		
		return term1 + term2 + term3;
	}
	
	public static int fillLeftFirst(boolean[] fishing, int peopleNum, int gate) {
		int distance = 1;
		int cnt = 0;
		
		if (!fishing[gate]) {
			fishing[gate] = true; // 1명 채워넣기
			if (++cnt == peopleNum) return 1;
		}
		
		int dis = 1;
		int idx;
		while (true) {
			idx = gate - dis;
			if (idx >= 0 && idx < N && !fishing[idx]) {
				fishing[idx] = true;
				distance += dis;
				if (distance > minDis) return Integer.MAX_VALUE;
				if (++cnt == peopleNum) break;
			}
			
			idx = gate + dis;
			if (idx >= 0 && idx < N && !fishing[idx]) {
				fishing[idx] = true;
				distance += dis;
				if (distance > minDis) return Integer.MAX_VALUE;
				if (++cnt == peopleNum) break;
			}
			
			dis++;
		}
		
		return distance;
	}
	
	public static int fillRightFirst(boolean[] fishing, int peopleNum, int gate) {
		int distance = 1;
		int cnt = 0;
		
		if (!fishing[gate]) {
			fishing[gate] = true; // 1명 채워넣기
			if (++cnt == peopleNum) return 1;
		}
		
		int dis = 1;
		int idx;
		while (true) {
			idx = gate + dis;
			if (idx >= 0 && idx < N && !fishing[idx]) {
				fishing[idx] = true;
				distance += dis;
				if (distance > minDis) return Integer.MAX_VALUE;
				if (++cnt == peopleNum) break;
			}
			
			idx = gate - dis;
			if (idx >= 0 && idx < N && !fishing[idx]) {
				fishing[idx] = true;
				distance += dis;
				if (distance > minDis) return Integer.MAX_VALUE;
				if (++cnt == peopleNum) break;
			}
			
			dis++;
		}
		
		return distance;
	}
	
	
}
