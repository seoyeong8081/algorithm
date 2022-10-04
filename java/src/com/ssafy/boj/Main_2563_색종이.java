package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2563_색종이 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		boolean[][] plane = new boolean[100][100];

		int N = Integer.parseInt(in.readLine());
		int x, y;
		String[] inputXY;
		for (int n = 0; n < N; n++) {
			inputXY = in.readLine().split(" ");
			x = Integer.parseInt(inputXY[0]);
			y = Integer.parseInt(inputXY[1]);

			for (int dx = x; dx < x + 10; dx++) {
				for (int dy = y; dy < y + 10; dy++) {
					if (!plane[dx][dy]) {
						plane[dx][dy] = true;
						ans++;
					}
//					plane[dx][dy] = true;
				}
			}
		}
		
//		for (x = 0; x < 100; x++) {
//			for (y = 0; y < 100; y++) {
//				if (plane[x][y]) 
//					ans++;
//			}
//		}

		System.out.println(ans);
	}

}
