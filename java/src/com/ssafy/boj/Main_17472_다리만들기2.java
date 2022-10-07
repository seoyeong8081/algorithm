package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 크루스칼, 프림 알고리즘 찾아보기
public class Main_17472_다리만들기2 {
	
	static int N, M;
	static int islandNum = 0;
	static int map[][];
	
	static List<int[]> bridges = new ArrayList<int[]>(); // int islandA, int islandB, int bridgelength
	
	static int ans = -1;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬에 넘버링하기
		isVisited = new boolean[N][M];
		numberingIsland();
		

		
		// 연결할 수 있는 다리 list에 넣기
		// 섬끼리 연결할 경우 다리 거리는  2이상
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					connectIsland(i, j);
				}
			}
		}
		
//		// debugging
//		System.out.println("---------------!bridge!----------------");
//		for (int[] bridge : bridges) {
//			System.out.println(bridge[0] + " " + bridge[1] + " " + bridge[2]);
//		}
		
		
		// 섬 - 1 
		Kruskal();
		System.out.println(ans);
	}

	static boolean isVisited[][];
	private static void numberingIsland() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !isVisited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void bfs(int i, int j) {
		islandNum++;
		Queue<int[]> que = new ArrayDeque<int[]>();
		que.offer(new int[] {i, j});
		isVisited[i][j] = true;
		map[i][j] = islandNum;
		
		int[] cur;
		int nr, nc;
		while (!que.isEmpty()) {
			cur = que.poll();
			for (int idx = 0; idx < 4; idx++) {
				nr = cur[0] + dr[idx];
				nc = cur[1] + dc[idx];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || isVisited[nr][nc]) continue;
				que.offer(new int[] {nr, nc});
				isVisited[nr][nc] = true;
				map[nr][nc] = islandNum;
			}
		}
	}

	static int parent[];
	private static void Kruskal() {
		bridges.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		parent = new int[islandNum];
		for (int i = 0; i < islandNum; i++) {
			parent[i] = i;
		}
		
		int ansTmp = 0;
		int kruskalCnt = 0;
		for (int[] bridge : bridges) {
			if (union(bridge[0], bridge[1])) {
				ansTmp += bridge[2];
				if (++kruskalCnt == islandNum - 1) {
					ans = ansTmp;
					break;
				}
			}
		}
		
	}

	private static boolean union(int i, int j) {
		int parentI = find(i);
		int parentJ = find(j);
		
		if (parent[i] == parent[j]) return false;
		
		parent[parentI] = parentJ;
		return true;
	}

	private static int find(int i) {
		if (parent[i] == i) return i;
		return parent[i] = find(parent[i]);
	}

	private static void connectIsland(int i, int j) {
		// (i, j)에서 다리를 놓을 수 있는지 체크
		int nr, nc, cnt;
		HERE : for (int idx = 0; idx < 4; idx++) {
			nr = i;
			nc = j;
			cnt = -1;
			do {
				nr += dr[idx];
				nc += dc[idx];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue HERE;
				cnt++;
				
			} while (map[nr][nc] == 0);
			if (cnt >= 2 && map[i][j] != map[nr][nc]) {
				bridges.add(new int[] {map[i][j] - 1, map[nr][nc] - 1, cnt});				
			}
		}
		
		
	}
	
	
}
