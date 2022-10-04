package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

// DFS로 푸는게 더 빠름 한번에 뭉텅이로 가지치기 하니까
public class Main_10971_외판원순회2 {

	public static int N;
	public static int[][] adjArray;
	public static int[] perm;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		adjArray = new int[N][N];
		perm = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				adjArray[i][j] = Integer.parseInt(st.nextToken());
			}
			perm[i] = i;
		}

		int ans = Integer.MAX_VALUE;
		int temp, add;
		Loop : do {
//			System.out.println(Arrays.toString(perm));
			temp = 0;
			for (int i = 0; i < N - 1; i++) {
				add = adjArray[perm[i]][perm[i + 1]];
				if (add == 0 || temp >= ans) {
					continue Loop;
				}
				temp += add;
			}
			add = adjArray[perm[N - 1]][perm[0]];
			if (add == 0) {
				continue;
			}
			temp += add;
			if (temp < ans)
				ans = temp;
		} while (nextPermutation() && perm[0] == 0);
		
		System.out.println(ans);
		
	}
	
	public static boolean nextPermutation() {
		// 1. 꼭대기 찾기
		int i = N - 1;
		while (i > 0 && perm[i - 1] > perm[i])
			i--;
		if (i == 0)
			return false;

		// 2. 바꿀 애 찾기
		int j = N - 1;
		while (perm[i - 1] > perm[j])
			j--;

		// 3. 바꾸기
		swap(i - 1, j);

		// 4. 뒤에 오름차순 정렬
		int k = N - 1;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	public static void swap(int i, int j) {
		int temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;
	}

}
