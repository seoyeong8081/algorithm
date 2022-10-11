package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		int[] foodCount = new int[d + 1];
		int[] food = new int[N];
		foodCount[c]++;
		int maxNum = 0;
		int foodNum = 1;
		
		for (int i = 0; i < N + k - 1; i++) {
			// k-1 개 계산 추가
			if (i < N) {
			food[i] = Integer.parseInt(in.readLine());
			}
			if (i < k) {
				if (foodCount[food[i]]++ == 0) {
					foodNum++;
				}
			}
			if (i >= k && i < N) { // 하나씩 넣고 앞에꺼 빼기
				if (foodCount[food[i]]++ == 0) {
					foodNum++;
				}
				if (--foodCount[food[i - k]] == 0) {
					foodNum--;
				}
			} else if (i >= N) {
				if (--foodCount[food[i - k]] == 0) {
					foodNum--;
				}
				if (foodCount[food[i % N]]++ == 0) {
					foodNum++;
				}
			}
			if (i >= k - 1) { // 몇 개인지 계산
				maxNum = Math.max(maxNum, foodNum);
			}
		}
		
		System.out.println(maxNum);
	}
	
}
