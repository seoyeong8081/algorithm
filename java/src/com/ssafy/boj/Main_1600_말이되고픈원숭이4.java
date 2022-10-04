package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이4 {


	static final int MAXWH = 200;
	static final int MAXK  = 30;
	static final int INF   = MAXK * 2;

	static int W, H, K;
	static int[][] map = new int[MAXWH][MAXWH];

	static void readData() throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

	    int n;
	    for (int h = 0; h < H; h++) {
	    	st = new StringTokenizer(in.readLine(), " ");
	        for (int w = 0; w < W; w++) {
	            n = Integer.parseInt(st.nextToken());
	            map[h][w] = n * INF - 1;
	        }
	    }
	    map[H - 1][W - 1] = -INF;
	}

	static int getMinMove() {
	    int[] dx = { 1, -1, 0,  0,  -1,  1, -1, 1, -2,  2, -2, 2};
	    int[] dy = { 0,  0, 1, -1,  -2, -2,  2, 2, -1, -1,  1, 1};

	    if (W == 1 && H == 1)   return 0;

	    Queue<int[]> que = new ArrayDeque<>();
	    que.offer(new int[] {0, 0, K}); // {x, y, d, k}
	    map[0][0] = K;
	    
	    int xx, yy;
	    int d;
	    int cnt = 0;

	    while (!que.isEmpty()) {
	    	d = que.size();
	    	cnt++;
	    	while (d != 0) {
	    		d--;
	    		int[] current = que.poll();
	    		int x = current[0];
	    		int y = current[1];
	    		int k = current[2];
	    		
	    		for (int i = 0; i < 4; i++) {
	    			xx = x + dx[i];
	    			yy = y + dy[i];
	    			if (xx < 0 || xx >= W || yy < 0 || yy >= H) continue;
	    			if (map[yy][xx] < k) {
	    				if ( map[yy][xx] == -INF)   return cnt;
	    				map[yy][xx] = k;
	    				que.offer(new int[] {xx, yy, k});
	    			}
	    		}
	    		
	    		if (k > 0) {
	    			k--;
	    			for (int i = 4; i < 12; i++) {
	    				xx = x + dx[i];
	    				yy = y + dy[i];
	    				if (xx < 0 || xx >= W || yy < 0 || yy >= H) continue;
	    				if (map[yy][xx] < k) {
	    					if ( map[yy][xx] == -INF)   return cnt;
	    					map[yy][xx] = k;
	    					que.offer(new int[] {xx, yy, k});
	    				}
	    			}
	    		}
	    	}
	        
//	        // debugging
//	        for (int i = 0; i < que.size(); i++) {
//	        	int[] debug = que.peek();
//				System.out.print("{" + debug[0] + ", " + debug[1] + ", " + debug[2] + ", " + debug[3] + "}, ");
//	        }
//	        System.out.println();
//	        
//	        for (int i = 0; i < H; i++) {
//	        	for (int j = 0; j < W; j++) {
//	        		System.out.print(map[i][j] + " ");
//	        	}
//	        	System.out.println();
//	        }
	    }
	    return -1;
	}


	
	public static void main(String[] args) throws Exception{
		readData();
		System.out.println(getMinMove());
	}

	
}
