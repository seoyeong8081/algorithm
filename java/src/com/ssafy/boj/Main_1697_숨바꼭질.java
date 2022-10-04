package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int SIZE = 100001;
		boolean[] isVisited = new boolean[SIZE];//
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(N);
		isVisited[N] = true;//
		
		int cur;
		int qSize;
		int time = 0;
		int next;
		
		if (N == K) {
			System.out.println(0);
			return;
		}
		while (true) {
			qSize = queue.size();
			time++;
			
			while (qSize != 0) {
				cur = queue.poll();
				qSize--;
				
				next = 2 * cur;
				if (next == K) {
					System.out.println(time);
					return;
				} 
				if (next >= 0 && next < SIZE && !isVisited[next]) {
					isVisited[next] = true;
					queue.offer(next);
				}
				
				next = cur + 1;
				if (next == K) {
					System.out.println(time);
					return;
				} 
				if (next >= 0 && next < SIZE && !isVisited[next]) {
					isVisited[next] = true;
					queue.offer(next);
				}
				
				next = cur - 1;
				if (next == K) {
					System.out.println(time);
					return;
				} 
				if (next >= 0 && next < SIZE && !isVisited[next]) {
					isVisited[next] = true;
					queue.offer(next);
				}
			}
			
		}
	}
	
	

}
