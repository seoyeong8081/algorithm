package com.ssafy.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2164_카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> card = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			card.add(i+1);
		}
		
		while (card.size() > 1) {
			card.remove();
			card.add(card.poll());
		}
		System.out.println(card.poll());
		sc.close();
	}

}
