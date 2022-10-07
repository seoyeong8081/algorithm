package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	
	static int input[][];
	static int N;
	static boolean isContained[];
	static int population[];
	static int num[];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
//		size = new int[N + 1];
		
		// 1을 중심으로 각각의 케이스 다 따지기
		// 주변꺼 넣거나 말거나
		// 그냥 조합으로 할까
		// 일단 조합으로 해보자
		population = new int[N]; // 인구 수 저장
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		input = new int[N][];
		num = new int[N];
//		int num;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			num[i] = Integer.parseInt(st.nextToken());
			input[i] = new int[num[i]];
			for (int j = 0; j < num[i]; j++) {
				input[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
		}
		
		// debugging
//		System.out.println("test=====================");
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < num[i]; j++) {
//				System.out.print(input[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("test=====================");
		// ----------
		
		// 조합 만들기 조합보단 1을 포함한 부분집합
		isContained = new boolean[N];
		isContained[0] = true;
		subset(1);
		
		// 다 포함되어있는 경우 빼주기
		
		if (ans != Integer.MAX_VALUE) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
	}

	private static void subset(int i) {
		if (i == N) {
			// 두 구역이 이어져있는지 판단
			if (isConnected()) {
				// 인구 차이 계산하여 업데이트
				calcAns();
			}
			return;
		}
		
		isContained[i] = false;
		subset(i + 1);
		isContained[i] = true;
		subset(i + 1);
		
	}

//	static List<Integer> islandA;
//	static List<Integer> islandB;
	private static boolean isConnected() {
//		//debugging
//		System.out.println("------------------------");
//		System.out.println(Arrays.toString(isContained));
//		System.out.println(isConnectedBfs(true) + " " + isConnectedBfs(false));
//		//------------
		
		if (isConnectedBfs(true) && isConnectedBfs(false)) {
			return true;
		}
		return false;
	}

	private static boolean isConnectedBfs(boolean b) {
		// 큐에 첫번째 원소 넣기
		int sizeIsland = 0;
		int idx = -1;
		for (int i = 0; i < N; i++) {
			if (isContained[i] == b) {
				sizeIsland++;
				if (idx == -1) idx = i;
			}
		}
		if (sizeIsland == 0) return false;
		
		Queue<Integer> que = new ArrayDeque<>();
		boolean isVisited[] = new boolean[N];
		que.offer(idx);
		isVisited[idx] = true;
		
		int cnt = 0;
		int cur;
		int next;
		while (!que.isEmpty()) {
			// 꺼내서 걔의 인접리스트 확인하기
			cur = que.poll();
			cnt++;
			
			// 인접리스트 중에 boolean같은 게 있으면 큐에 넣어주기
			for (int i = 0; i < num[cur]; i++) {
				next = input[cur][i];
				if (!isVisited[next] && isContained[next] == b) {
					que.offer(next);
					isVisited[next] = true;
				}
			}
			
		}
		
		// 사이즈 세주기
		if (cnt == sizeIsland) {
			return true;
		} else {
			return false;
		}
	}

	private static void calcAns() {
		int popul = 0;
		for (int i = 0; i < N; i++) {
			if (isContained[i]) {
				popul += population[i];
			} else {
				popul -= population[i];
			}
		}
		ans = Math.min(ans, Math.abs(popul));
	}
	
	
	
}
