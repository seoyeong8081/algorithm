package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이3 {
//	testcase
//	2
//	2 6
//	0 1
//	1 1
//	1 0
//	1 1
//	0 1
//	0 0

	static final int MAXWH = 200;
	static final int MAXK  = 30;
	static final int INF   = MAXK * 2;

	static int W, H, K;
	static int[][] map = new int[MAXWH + 4][MAXWH + 4];

	static void readData() throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

	    int n;
	    for (int h = 2; h < H + 2; h++) {
	    	st = new StringTokenizer(in.readLine(), " ");
	        for (int w = 2; w < W + 2; w++) {
	            n = Integer.parseInt(st.nextToken());
	            map[h][w] = n * INF - 1;
	        }
	        map[h][0] = map[h][1] = map[h][W + 2] = map[h][W + 3] = INF;
	    }
	    for (int w = 0; w < W + 4; w++) {
	        map[0][w] = map[1][w] = map[H + 2][w] = map[H + 3][w] = INF;
	    }
	    map[H + 1][W + 1] = -INF;
	}

	static int getMinMove() {
	    int[] dx = { 1, -1, 0,  0,  -1,  1, -1, 1, -2,  2, -2, 2};
	    int[] dy = { 0,  0, 1, -1,  -2, -2,  2, 2, -1, -1,  1, 1};

	    if (W == 1 && H == 1)   return 0;

	    Queue<int[]> que = new ArrayDeque<>();
	    que.offer(new int[] {2, 2, 0, K}); // {x, y, d, k}
	    map[2][2] = K;
	    
	    int xx, yy;

	    while (!que.isEmpty()) {
	    	int[] current = que.poll();
			int x = current[0];
			int y = current[1];
			int d = current[2];
			int k = current[3];
	        d++;
	        
	        for (int i = 0; i < 4; i++) {
	            xx = x + dx[i];
	            yy = y + dy[i];
	            if (map[yy][xx] < k) {
	                if ( map[yy][xx] == -INF)   return d;
	                map[yy][xx] = k;
	                que.offer(new int[] {xx, yy, d, k});
	            }
	        }

	        if (k > 0) {
	            k--;
	            for (int i = 4; i < 12; i++) {
	                xx = x + dx[i];
	                yy = y + dy[i];
	                if (map[yy][xx] < k) {
	                    if ( map[yy][xx] == -INF)   return d;
	                    map[yy][xx] = k;
	                    que.offer(new int[] {xx, yy, d, k});
	                }
	            }
	        }
	        
	        for (int i = 0; i < que.size(); i++) {
	        	int[] debug = que.peek();
				System.out.print("{" + debug[0] + ", " + debug[1] + ", " + debug[2] + ", " + debug[3] + "}, ");
	        }
	        System.out.println();
	        
	        for (int i = 0; i < H + 4; i++) {
	        	for (int j = 0; j < W + 4; j++) {
	        		System.out.print(map[i][j] + " ");
	        	}
	        	System.out.println();
	        }
	    }
	    return -1;
	}


	
	public static void main(String[] args) throws Exception{
		readData();
		System.out.println(getMinMove());
	}

	
}
