package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int swNum = Integer.parseInt(in.readLine());
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int[] arr = new int[swNum];
		int i = 0;
		int gender = 0;
		int multiple = 0;
		for (i = 0; i < swNum; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int pNum = Integer.parseInt(in.readLine());
		for (i = 0; i < pNum; i++) {
			str = in.readLine();
			st = new StringTokenizer(str);
			gender = Integer.parseInt(st.nextToken());
			multiple = Integer.parseInt(st.nextToken());
			int current = multiple - 1;
			if (gender == 1) { //male
				while (current < swNum) {
					arr[current] = (arr[current] + 1) % 2;
					current += multiple;
				}
			} else { //female
				arr[current] = (arr[current] + 1) % 2;
				int right = current + 1;
				int left = current - 1;
				while ((right < swNum) && (left >= 0) && (arr[left] == arr[right])) {
					arr[left] = (arr[left] + 1) % 2;
					arr[right] = (arr[right] + 1) % 2;
					right++;
					left--;
				}
				
			}
			
		}
		
		
		for (i = 0; i < swNum; i++) {
			out.append(arr[i]).append(" ");
			if (i % 20 == 19) {
				out.append("\n");
			}
		}
		System.out.println(out);
	}
}
