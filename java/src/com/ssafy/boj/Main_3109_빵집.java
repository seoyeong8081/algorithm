package com.ssafy.boj;
//마저풀기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	
	public static int R, C;
	public static int ans;
//	public static List<Integer> rpath;
//	public static List<Integer> cpath;
	public static char[][] map;
//	public static boolean[][] isVisited;
	public static int[] isVisited;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
//		rpath = new ArrayList<>(C);
//		cpath = new ArrayList<>(C);
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		// 오른쪽 끝에 도착해야 true로 바꿔야하는데
//		isVisited = new boolean[R][C]; // 오른쪽위 먼저 탐색
		isVisited = new int[R];
		
		for (int i = 0; i < R; i++) {
			rpath.clear();
			cpath.clear();
			visitPosition(i, 0);
		}
		System.out.println(ans);
	}
	
	public static boolean visitPosition(int r, int c) {
		rpath.add(r);
		cpath.add(c);
		
		if (c == C - 1) {
			ans++;
//			visitCheck(rpath, cpath, isVisited);
			for (int i = 0; i < C; i++) {
				isVisited[rpath.get(i)][cpath.get(i)] = true;
			}
			
			return true;
		}
		
//		for (int i = 0; i < map.length; i++) { // test
//			for (int j = 0; j < map[i].length; j++) {
//				if (isVisited[i][j]) {
//					System.out.print(1);
//				} else {
//					System.out.print(0);
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		int nextR = r - 1;
		int nextC = c + 1;
		if (nextR >= 0 && nextR < R && map[nextR][nextC] == '.' && !isVisited[nextR][nextC]) {
			if (visitPosition(nextR, nextC)) {
				rpath.remove(rpath.size() - 1);
				cpath.remove(cpath.size() - 1);
				return true;
			}
		}
		nextR = r;
		if (nextR >= 0 && nextR < R && map[nextR][nextC] == '.' && !isVisited[nextR][nextC]) {
			if (visitPosition(nextR, nextC)) {
				rpath.remove(rpath.size() - 1);
				cpath.remove(cpath.size() - 1);
				return true;
			}
		}
		nextR = r + 1;
		if (nextR >= 0 && nextR < R && map[nextR][nextC] == '.' && !isVisited[nextR][nextC]) {
			if (visitPosition(nextR, nextC)) {
				rpath.remove(rpath.size() - 1);
				cpath.remove(cpath.size() - 1);
				return true;
			}
		}
		
		return false;
	}

}
