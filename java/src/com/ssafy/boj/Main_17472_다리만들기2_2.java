package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 크루스칼, 프림 알고리즘 찾아보기
// 이렇게 절대 노노노노노노노노
// 섬안에 섬 있을 수도 있음
public class Main_17472_다리만들기2_2 {
	
	static int island[][][] = new int[6][10][2];
	static int islandC[][][] = new int[6][10][2];
	static int islandRInterval[][] = new int[6][2];
	static int islandCInterval[][] = new int[6][2];
	static int islandNum = 0;
	static int map[][];
	
	static List<int[]> bridges = new ArrayList<int[]>();
	
	static int ans;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int maxNM = Math.max(N, M);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < maxNM; j++) {
				island[i][j][0] = -1;
				island[i][j][1] = -1;
				islandC[i][j][0] = -1;
				islandC[i][j][1] = -1;
			}
		}
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 인식 어떻게 하지
		// 겉에 부분만 일단 다 넣어둘까? 노노
		// r범위, c범위 저장해서 연결할 수 있는지 체크해야 할듯
		// r범위 겹치면 가로로 연결 가능 , c범위 겹치면 세로로 연결 가능
		//[6][10][2] 섬 / 행 / 시작 끝
//		int island[][][] = new int[6][10][2];
//		int islandNum = 0;
		int start = -1;
		int end = 0;
		for (int i = 0; i < N; i++) {
			start = -1;
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					if (start == -1) {
						start = j;
						end = j;
					} else {
						end = j;
					}
				} else {
					if (start != -1) {
						inputIsland(i, start, end);
					}
					start = -1;
				}
			}
			if (start != -1) {
				inputIsland(i, start, end);
			}
		}
		
//		// debugging
//		for (int i = 0; i < islandNum; i++) {
//			System.out.println(islandRInterval[i][0] + " " + islandRInterval[i][1]);
//		}
//		System.out.println("================");
//		for (int i = 0; i < islandNum; i++) {
//			System.out.println(islandCInterval[i][0] + " " + islandCInterval[i][1]);
//		}
//		System.out.println("================");
//		for (int i = 0; i < islandNum; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.println("(" + j + ", " + island[i][j][0] + ")(" + j + ", " + island[i][j][1] + ")");
//			}
//			System.out.println("--------------------");
//		}
//		System.out.println("================");
//		for (int i = 0; i < islandNum; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.println("(" + islandC[i][j][0] + ", " + j + ")(" + islandC[i][j][1] + ", " + j + ")");
//			}
//			System.out.println("--------------------");
//		}
		
		// 연결할 수 있는 다리 list에 넣기
		// 섬끼리 연결할 경우 다리 거리 / 2이상
		for (int i = 0; i < islandNum; i++) {
			for (int j = i + 1; j < islandNum; j++) {
				connectIsland(i, j);
			}
		}
		
		// 섬끼리 연결된거 표현 어떻게 하지
		// 다리의 개수는 
		// 섬 - 1 이상
		// 최소 다리이려면 섬 - 1?
		// 총 다리 개수에서 (섬 - 1)개 뽑기?
		if (bridges.size() < islandNum - 1) {
			System.out.println(-1);
			return;
		}
		
		// 섬 - 1 
		Kruskal();
		System.out.println(ans);
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
		
		ans = 0;
		int kruskalCnt = 0;
		for (int[] bridge : bridges) {
			if (union(bridge[0], bridge[1])) {
				ans += bridge[2];
				if (++kruskalCnt == islandNum - 1) break;
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
		// 행이 겹치면
//		if ((islandRInterval[i][0] <= islandRInterval[j][1] && islandRInterval[j][0] <= islandRInterval[i][0]) ||
//				(islandRInterval[i][1] <= islandRInterval[j][1] && islandRInterval[j][0] <= islandRInterval[i][1])) {
//			
//		}
//		int minR = 0;
//		int minC = 0;
		int bridgeLength = 12;
		int cnt = 0;
		
		if ((islandRInterval[i][0] <= islandRInterval[j][1] && islandRInterval[j][0] <= islandRInterval[i][0]) ||
				(islandRInterval[i][1] <= islandRInterval[j][1] && islandRInterval[j][0] <= islandRInterval[i][1])) {
		HERE : for (int r = islandRInterval[i][0]; r <= islandRInterval[i][1]; r++) {
			if (r >= islandRInterval[j][0] && r <= islandRInterval[j][1]) {
				// 다리 행 r에 가로로 놓을 수 있음
				if (island[i][r][1] < island[j][r][0]) {
					// i가 왼쪽 j가 오른쪽
					cnt = 0;
					for (int c = island[i][r][1] + 1; c < island[j][r][0]; c++) {
						if (map[r][c] == 1) continue HERE;
						cnt++;
					}
					if (cnt >= 2 && cnt < bridgeLength) {
						bridgeLength = cnt;
					}
				} else {
					// j가 왼쪽 i가 오른쪽
					cnt = 0;
					for (int c = island[j][r][1] + 1; c < island[i][r][0]; c++) {
						if (map[r][c] == 1) continue HERE;
						cnt++;
					}
					if (cnt >= 2 && cnt < bridgeLength) {
						bridgeLength = cnt;
					}
				}
			}
		}
		}
		
		if (bridgeLength != 12) {
			bridges.add(new int[] {i, j, bridgeLength});
		}
		
		// 열이 겹치면
		if ((islandCInterval[i][0] <= islandCInterval[j][1] && islandCInterval[j][0] <= islandCInterval[i][0]) ||
				(islandCInterval[i][1] <= islandCInterval[j][1] && islandCInterval[j][0] <= islandCInterval[i][1])) {
		HERE2 : for (int c = islandCInterval[i][0]; c <= islandCInterval[i][1]; c++) {
			if (c >= islandCInterval[j][0] && c <= islandCInterval[j][1]) {
				// 다리 행 c에 세로로 놓을 수 있음
				if (islandC[i][c][1] < islandC[j][c][0]) {
					// i가 위쪽 j가 아래쪽
					cnt = 0;
					for (int r = islandC[i][c][1] + 1; r < islandC[j][c][0]; r++) {
						if (map[r][c] == 1) continue HERE2;
						cnt++;
					}
					if (cnt >= 2 && cnt < bridgeLength) {
						bridgeLength = cnt;
					}
				} else {
					// j가 위쪽 i가 아래쪽
					cnt = 0;
					for (int r = islandC[j][c][1] + 1; r < islandC[i][c][0]; r++) {
						if (map[r][c] == 1) continue HERE2;
						cnt++;
					}
					if (cnt >= 2 && cnt < bridgeLength) {
						bridgeLength = cnt;
					}
				}
			}
		}
		}
		
		if (bridgeLength != 12) {
			bridges.add(new int[] {i, j, bridgeLength});
		}
	}

	private static void inputIsland(int r, int start, int end) {
		if (r == 0) {
			island[islandNum][r][0] = start;
			island[islandNum][r][1] = end;
			for (int i = start; i <= end; i++) {
				islandC[islandNum][i][0] = r;
				islandC[islandNum][i][1] = r;
			}
			islandRInterval[islandNum][0] = r;
			islandRInterval[islandNum][1] = r;
			islandCInterval[islandNum][0] = start;
			islandCInterval[islandNum][1] = end;
			islandNum++;
		} else {
			boolean isFind = false;
			for (int i = 0; i < islandNum; i++) {
				if (island[i][r-1][0] == -1 && island[i][r-1][1] == -1) continue;
				// **     ***  **    **  ****
				//****    ***   **  **    **
				int startBef = island[i][r-1][0];
				int endBef = island[i][r-1][1];
				
				if ((startBef <= start && start <= endBef) ||
				(start <= startBef && startBef <= end)) {
					island[i][r][0] = start;
					island[i][r][1] = end;
					for (int j = start; j <= end; j++) {
						if (islandC[i][j][0] == -1) islandC[i][j][0] = r;
						islandC[i][j][1] = r;
					}
					islandRInterval[i][1] = r;
					if (start < islandCInterval[i][0]) islandCInterval[i][0] = start;
					if (end > islandCInterval[i][1]) islandCInterval[i][1] = end;
					isFind = true;
					break;
				}
			}
			if (!isFind) {
				island[islandNum][r][0] = start;
				island[islandNum][r][1] = end;
				for (int i = start; i <= end; i++) {
					islandC[islandNum][i][0] = r;
					islandC[islandNum][i][1] = r;
				}
				islandRInterval[islandNum][0] = r;
				islandRInterval[islandNum][1] = r;
				islandCInterval[islandNum][0] = start;
				islandCInterval[islandNum][1] = end;
				islandNum++;
			}
		}
	}
	
}
