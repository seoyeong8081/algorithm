package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1873_상호의배틀필드 {

	public static void main(String[] args) throws Exception{
		File file = new File("src\\com\\ssafy\\swea\\input_1873.txt");
		System.setIn(new FileInputStream(file));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		int H = 0;
		int W = 0;
		@SuppressWarnings("unused")
		int N = 0;
		int currentH = 0;
		int currentW = 0;
		int nextH = 0;
		int nextW = 0;
//		int dir = 0; //0:^ 1:v 2:< 3:>
		for (int testcase = 0; testcase < tc; testcase++) {
			String[] strArr = in.readLine().split(" ");
			H = Integer.parseInt(strArr[0]);
			W = Integer.parseInt(strArr[1]);
			
			char[][] map = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				map[i] = in.readLine().toCharArray();
			}
			N = Integer.parseInt(in.readLine());
//			char[] userInput = new char[N];
			char[] userInput = in.readLine().toCharArray(); //???
			
			Find: for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					switch (map[i][j]) {
					case '^':
						currentH = i;
						currentW = j;
						break Find;
					case 'v':
						currentH = i;
						currentW = j;
						break Find;
					case '<':
						currentH = i;
						currentW = j;
						break Find;
					case '>':
						currentH = i;
						currentW = j;
						break Find;
					default:
						break;
					}
				}
			}
			
			for (char input : userInput) {
				switch (input) {
				case 'U':
					map[currentH][currentW] = '^';
					nextH = currentH - 1;
					nextW = currentW;
					if (checkNext(map, nextH, nextW, currentH, currentW, H, W)) {
						currentH = nextH;
						currentW = nextW;
					}
					break;
				case 'D':
					map[currentH][currentW] = 'v';
					nextH = currentH + 1;
					nextW = currentW;
					if (checkNext(map, nextH, nextW, currentH, currentW, H, W)) {
						currentH = nextH;
						currentW = nextW;
					}
					break;
				case 'L':
					map[currentH][currentW] = '<';
					nextH = currentH;
					nextW = currentW - 1;
					if (checkNext(map, nextH, nextW, currentH, currentW, H, W)) {
						currentH = nextH;
						currentW = nextW;
					}
					break;
				case 'R':
					map[currentH][currentW] = '>';
					nextH = currentH;
					nextW = currentW + 1;
					if (checkNext(map, nextH, nextW, currentH, currentW, H, W)) {
						currentH = nextH;
						currentW = nextW;
					}
					break;
				case 'S':
					shoot(map, currentH, currentW, H, W);
					break;
				default:
					break;
				}
			}
			
			out.append("#").append(testcase + 1).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					out.append(map[i][j]);
				}
				out.append("\n");
			}
			
		}
		
		System.out.println(out);
		
		
	}
	
	public static boolean checkNext(char[][] map, int nextH, int nextW, int curH, int curW, int Hsize, int Wsize) {
		if (nextH < 0 || nextH >= Hsize || nextW < 0 || nextW >= Wsize)
			return false;
		
		if (map[nextH][nextW] == '.') {
			map[nextH][nextW] = map[curH][curW];
			map[curH][curW] = '.';
			return true;
		}
		return false;
	}
	
	public static void shoot(char[][] map, int curH, int curW, int hSize, int wSize) {
		int dir = -1;
		switch (map[curH][curW]) {
		case '^':
			dir = 0;
			break;
		case 'v':
			dir = 1;
			break;
		case '<':
			dir = 2;
			break;
		case '>':
			dir = 3;
			break;
		default:
			break;
		}
		
		int[] dh = {-1, 1, 0, 0};
		int[] dw = {0, 0, -1, 1};
		
		int nextH = curH + dh[dir];
		int nextW = curW + dw[dir];
		
		while (nextH >=0 && nextH < hSize && nextW >= 0 && nextW < wSize) {
			if (map[nextH][nextW] == '*') {
				map[nextH][nextW] = '.';
				break;
			} else if (map[nextH][nextW] == '#') {
				break;
			}
			
			nextH += dh[dir];
			nextW += dw[dir];
		}
	}
	
}
