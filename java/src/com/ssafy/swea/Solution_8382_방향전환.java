package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8382_방향전환 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder out = new StringBuilder();
		int cnt;
		int x1, y1, x2, y2;
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			cnt= 0;
			st = new StringTokenizer(in.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			int dx = Math.abs(x2 - x1);
			int dy = Math.abs(y2 - y1);
			if (dx == dy) {
				cnt += 2 * dx;
			} else if (dx > dy) {
				cnt += 2 * dy;
				int next = dx - dy;
				if (next % 2 == 0) {
					cnt += 2 * next;
				} else {
					cnt += 2 * next - 1;
				}
			} else if (dx < dy) {
				cnt += 2 * dx;
				int next = dy - dx;
				if (next % 2 == 0) {
					cnt += 2 * next;
				} else {
					cnt += 2 * next - 1;
				}
			}
			
			
			out.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(out);
	}
	
}
