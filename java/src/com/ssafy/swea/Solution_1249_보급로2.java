package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
// 다익스트라로 풀어보기
public class Solution_1249_보급로2 {
	
//	static int[][] map;
//	static int[][] mintime;
//	static boolean[][] isMintime;
	
	public static class Point implements Comparable<Point>{
		int x, y, time;

		public Point(int x, int y, int minTime) {
			this.x = x;
			this.y = y;
			this.time = minTime;
		}

		@Override
		public int compareTo(Point o) {
			return time - o.time;
		}
		
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		StringBuilder out = new StringBuilder();
		
		int N;
		String input;
		int curR, curC, nr, nc;
//		int tmpR, tmpC, tmpTime;
//		int curMinTime;
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for (int T = 1; T <= tc; T++) {
			N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			int[][] mintime = new int[N][N];
//			boolean[][] isMintime = new boolean[N][N];
//			List<Point> list = new ArrayList<>();
			PriorityQueue<Point> list = new PriorityQueue<>();
			
			for (int i = 0; i < N; i++) {
				input = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
					mintime[i][j] = Integer.MAX_VALUE;
				}
			}
			
//			curR = 0;
//			curC = 0;
			mintime[0][0] = 0;
//			isMintime[0][0] = true;
			list.add(new Point(0, 0, 0));
			
			while (true) {
//				Collections.sort(list);
				Point cur = list.poll();
//				curR = list.peek().x;
//				curC = list.peek().y;
//				curMinTime = list.peek().minTime;
//				list.poll();
//				isMintime[cur.x][cur.y] = true;
				
				if (cur.x == N - 1 && cur.y == N - 1) break;
//				tmpTime = Integer.MAX_VALUE;
//				tmpR = 0;
//				tmpC = 0;
				for (int i = 0; i < 4; i++) {
					nr = cur.x + dr[i];
					nc = cur.y + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
//					if (nr < 0 || nr >= N || nc < 0 || nc >= N || isMintime[nr][nc]) continue;
					
//					mintime[nr][nc] = Math.min(mintime[nr][nc], mintime[cur.x][cur.y] + map[nr][nc]);
					if (mintime[nr][nc] > mintime[cur.x][cur.y] + map[nr][nc]) {
						mintime[nr][nc] = mintime[cur.x][cur.y] + map[nr][nc];
						list.add(new Point(nr, nc, mintime[nr][nc]));
					}
//					if (mintime[nr][nc] < tmpTime) {
//						tmpTime = mintime[nr][nc];
//						tmpR = nr;
//						tmpC = nc;
//					}
				}
//				if (curR == tmpR && curC == tmpC) break;
//				curR = tmpR;
//				curC = tmpC;
//				isMintime[curR][curC] = true;
				
//				//debugging
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < N; j++) {
//						System.out.print(mintime[i][j] + " ");
//					}
//					System.out.println();
//				}
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < N; j++) {
//						System.out.print(isMintime[i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println("=============================");
			}
			
			out.append("#").append(T).append(" ").append(mintime[N-1][N-1]).append("\n");
		}
		
		System.out.println(out);
	}
	
}


//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.PriorityQueue;
// 
//class Solution
//{
//    static class Loc implements Comparable<Loc>{
//        int x;
//        int y;
//        int time;
// 
//        public Loc() {
//            super();
//        }
// 
//        public Loc(int x, int y, int time) {
//            super();
//            this.x = x;
//            this.y = y;
//            this.time = time;
//        }
// 
//        public int getX() {
//            return x;
//        }
// 
//        public void setX(int x) {
//            this.x = x;
//        }
// 
//        public int getY() {
//            return y;
//        }
// 
//        public void setY(int y) {
//            this.y = y;
//        }
// 
//        public int getTime() {
//            return time;
//        }
// 
//        public void setTime(int time) {
//            this.time = time;
//        }
// 
//        @Override
//        public int compareTo(Loc loc) {
//            return this.time - loc.time;
//        }
// 
//    }
// 
//    public static void main(String args[]) throws Exception
//    {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder result = new StringBuilder();
//        int T = Integer.parseInt(br.readLine());
//        int[][] move = { { 1, 0 }, { 0, 1 },{ 0, -1 }, { -1, 0 }};
//        for(int test_case = 1; test_case <= T; test_case++)
//        {
//            int N = Integer.parseInt(br.readLine());
//            int[][] map = new int[N][N];
//            int[][] sum = new int[N][N];        
//            for (int i = 0; i < N; i++) {
//                String input = br.readLine();
//                for (int j = 0; j < N; j++) {
//                    map[i][j] = input.charAt(j) - 48;
//                    sum[i][j] = 90000;
//                }
//            }
//            sum[0][0] = 0;
//             
//            PriorityQueue<Loc> pq = new PriorityQueue<>();
//            pq.add(new Loc(0,0,0));
//            while(!pq.isEmpty()) {
//                Loc now = pq.poll();
//                if(now.x == N - 1 && now.y == N - 1) {
//                    sum[now.x][now.y] = now.getTime();
//                    break;
//                }
//                 
//                int nextX, nextY;
//                for (int k = 0; k < 4; k++) {
//                    nextX = now.x + move[k][0];
//                    nextY = now.y + move[k][1];
//                    if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
//                        continue;
//                     
//                    if(sum[nextX][nextY] > sum[now.x][now.y] + map[nextX][nextY]) {
//                        sum[nextX][nextY] = sum[now.x][now.y] + map[nextX][nextY];
//                        pq.add(new Loc(nextX,nextY, sum[nextX][nextY]));
//                    }
//                }
//            }
//            result.append("#").append(test_case).append(" ").append(sum[N-1][N-1]).append("\n");
//        }
//        bw.write(result.toString());
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}
