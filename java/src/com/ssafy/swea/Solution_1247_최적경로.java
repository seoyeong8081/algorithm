package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	
	

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		int N = 0;
		List<Integer> customerX = new ArrayList<Integer>();
		List<Integer> customerY = new ArrayList<Integer>();
		int companyX = 0;
		int companyY = 0;
		int homeX = 0;
		int homeY = 0;
		StringTokenizer st;
		int[] nextPIndex;
		int ans, tmp;
		
		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(in.readLine());
			nextPIndex = new int[N];
			st = new StringTokenizer(in.readLine());
			companyX = Integer.parseInt(st.nextToken());
			companyY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				customerX.add(Integer.parseInt(st.nextToken()));
				customerY.add(Integer.parseInt(st.nextToken()));
				nextPIndex[i] = i;
			}
			
			
			do {
				tmp = calcTotalDist(companyX, companyY, homeX, homeY, customerX, customerY, nextPIndex);
				if (tmp < ans) ans = tmp;
			} while (nextPermutation(nextPIndex));
			
			out.append("#").append(tc).append(" ").append(ans).append("\n");
			
			customerX.clear();
			customerY.clear();
		}
		
		System.out.println(out);
	}
	
	public static int calcTotalDist(int startX, int startY, int endX, int endY, List<Integer> x, List<Integer> y, int[] index) {
		int N = x.size();
		int dist = distance(startX, startY, x.get(index[0]), y.get(index[0]));
		for (int i = 1; i < N; i++) {
			dist += distance(x.get(index[i - 1]), y.get(index[i - 1]), x.get(index[i]), y.get(index[i]));
		}
		dist += distance(x.get(index[N - 1]), y.get(index[N - 1]), endX, endY);
		
		return dist;
	}
	
	public static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	public static boolean nextPermutation(int[] arr) {
		int N = arr.length;
		// 1. 꼭대기 찾기
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) i--;
		if (i == 0) return false;
		
		// 2. 바꿀 거 찾기
		int j = N - 1;
		while (arr[i - 1] >= arr[j]) j--;
		
		// 3. 바꾸기
		swap(arr, i - 1, j);
		
		// 4. 뒤에 오름차순 정렬
		int k = N - 1;
		while (i < k) swap(arr, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
}
