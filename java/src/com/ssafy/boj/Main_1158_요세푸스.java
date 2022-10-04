package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_1158_요세푸스 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		out.append("<");
		int N, K;
		String[] inputs = in.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		K = Integer.parseInt(inputs[1]);
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while (queue.size() > 1) {
			for (int i = 0; i < K - 1; i++) {
				queue.add(queue.poll());
			}
			out.append(queue.poll()).append(", ");
		}
		out.append(queue.poll()).append(">");
		
		System.out.println(out);
		
		
	}

}
