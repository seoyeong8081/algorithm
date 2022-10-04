package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_3040_백설공주와일곱난쟁이 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> nine = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			nine.add(Integer.parseInt(in.readLine()));
		}
		
		int[] dwarf = {0, 0, 1, 1, 1, 1, 1, 1, 1};
		int sum = 0;
		do {
			sum = 0;
//			System.out.println(Arrays.toString(dwarf));
			for (int i = 0; i < 9; i++) {
				if (dwarf[i] == 1) sum += nine.get(i);
			}
			if (sum == 100) break;
		} while (nextPermu(dwarf));
		
		for (int i = 0; i < 9; i++) {
			if (dwarf[i] == 1) System.out.println(nine.get(i));
		}
		
	}
	
	public static boolean nextPermu(int[] numbers) {
		int N = numbers.length;
		//1. 꼭대기 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) i--;
		if (i == 0) return false;
		
		//2. 바꿀 j 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) j--;
		
		//3. 바꾸기
		swap(numbers, i - 1, j);
		
		//4. i부터 오름차순으로 정렬
		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
