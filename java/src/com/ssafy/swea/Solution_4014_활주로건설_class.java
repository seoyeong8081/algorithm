package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설_class {
	
	static int N, X, map[][], mapInverse[][];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			mapInverse = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine().trim());
				for (int j = 0; j < N; j++) {
					mapInverse[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#" + tc + " " + process());
		}
		
	}

	private static int process() {
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			if (makeRoad(map[i])) count++; // 수평 활주로 건설 체크
			if (makeRoad(mapInverse[i])) count++; // 수직 활주로 건설 체크
		}
		
		return count;
	}
	
	// 해당 지형 정보로 활주로 건설이 가능하면 true, 불가능하면 false 리턴
	private static boolean makeRoad(int[] road) {
		
		int beforeHeight = road[0], size = 0; // size = 1 아닌가?
		int j = 0;
		
		while (j < N) {
			if (beforeHeight == road[j]) { // 동일 높이
				size++;
				j++;
			} else if (beforeHeight + 1 == road[j]) { // 이전높이보다 1 높음 : 오르막 경사로 설치 체크
				if (size < X) return false; // X 길이 미만이면 활주로 건설 불가
				beforeHeight++;
				size = 1;
				j++;
			} else if (beforeHeight - 1 == road[j]) { // 이전높이보다 1 작음
				int count = 0;
				for (int k = j; k < N; k++) {
					if (road[k] != beforeHeight - 1) return false;
					
					if (++count == X) break;
				}
				
				if (count < X) return false;
				
				beforeHeight--;
				j += X;
				size = 0;
			} else { // 높이가 2이상 차이
				return false;
			}
		}
		
		return true;
	}
	
}
