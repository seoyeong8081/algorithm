package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {
	
//	public static int[][] arr;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		String str;
		StringTokenizer st;
		
		str = in.readLine();
		st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[Math.max(N, M)][Math.max(N, M)];
		
//		int[][] test = {{1, 2}, {3, 4}};
//		arr = test;
//		
//		printArr(arr, 2, 2);
		
		for (int row = 0; row < N; row++) {
			str = in.readLine();
			st = new StringTokenizer(str);
			for (int col = 0; col < M; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		str = in.readLine();
		st = new StringTokenizer(str);
		int command;
		int tmp;
		for (int i = 0; i < R; i++) {
			command = Integer.parseInt(st.nextToken());
			switch (command) {
			case 1:
				arr = command1(arr, N, M);
				break;
			case 2:
				command2(arr, N, M);
				break;
			case 3:
				command3(arr, N, M);
				tmp = N;
				N = M;
				M = tmp;
				break;
			case 4:
				command4(arr, N, M);
				tmp = N;
				N = M;
				M = tmp;
				break;
			case 5:
				command5(arr, N, M);
				break;
			case 6:
				command6(arr, N, M);
				break;

			default:
				break;
			}
		}
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				out.append(arr[row][col]).append(" ");
			}
			out.append("\n");
		}
		
		System.out.println(out);
	}
	
	public static int[][] command1(int[][] arr, int N, int M) {
		int[][] newArr = new int[N][M];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				newArr[row][col] = arr[N - 1 - row][col];
			}
		}
		
//		for (int row = 0; row < N; row++) {
//			arr[row] = newArr[row];
//		}
		return newArr;
	}
	
	public static void command2(int[][] arr, int N, int M) {
		int[][] newArr = new int[N][M];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				newArr[row][col] = arr[row][M - 1 - col];
			}
		}
		
		for (int row = 0; row < N; row++) {
			arr[row] = newArr[row];
		}
	}
	
	public static void command3(int[][] arr, int N, int M) {
		int[][] newArr = new int[M][N];
		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				newArr[row][col] = arr[N - 1 - col][row];
			}
		}
		
//		printArr(arr, N, M);
//		for (int row = 0; row < M; row++) { // 이건 되는데
//			arr[row] = newArr[row];
//		}
		arr = newArr; // 얘는 왜 안될까
		// 심지어 리턴값으로 주면 적용되는데
	}
	
	public static void command4(int[][] arr, int N, int M) {
		int[][] newArr = new int[M][N];
		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				newArr[row][col] = arr[col][M - 1 - row];
			}
		}
		
		for (int row = 0; row < M; row++) {
			arr[row] = newArr[row];
		}
	}
	
	public static void command5(int[][] arr, int N, int M) {
		int[][] newArr = new int[N][M];
		int halfN = N / 2;
		int halfM = M / 2;
		
		for (int row = 0; row < halfN; row++) {
			for (int col = 0; col < halfM; col++) {
				newArr[row][col] = arr[row + halfN][col];
			}
		}
		for (int row = 0; row < halfN; row++) {
			for (int col = halfM; col < M; col++) {
				newArr[row][col] = arr[row][col - halfM];
			}
		}
		for (int row = halfN; row < N; row++) {
			for (int col = halfM; col < M; col++) {
				newArr[row][col] = arr[row - halfN][col];
			}
		}
		for (int row = halfN; row < N; row++) {
			for (int col = 0; col < halfM; col++) {
				newArr[row][col] = arr[row][col + halfM];
			}
		}
		
		for (int row = 0; row < N; row++) {
			arr[row] = newArr[row];
		}
	}
	
	public static void command6(int[][] arr, int N, int M) {
		int[][] newArr = new int[N][M];
		int halfN = N / 2;
		int halfM = M / 2;
		
		for (int row = 0; row < halfN; row++) {
			for (int col = 0; col < halfM; col++) {
				newArr[row][col] = arr[row][col + halfM];
			}
		}
		for (int row = 0; row < halfN; row++) {
			for (int col = halfM; col < M; col++) {
				newArr[row][col] = arr[row + halfN][col];
			}
		}
		for (int row = halfN; row < N; row++) {
			for (int col = halfM; col < M; col++) {
				newArr[row][col] = arr[row][col - halfM];
			}
		}
		for (int row = halfN; row < N; row++) {
			for (int col = 0; col < halfM; col++) {
				newArr[row][col] = arr[row - halfN][col];
			}
		}
		
		for (int row = 0; row < N; row++) {
			arr[row] = newArr[row];
		}
	}
	
	public static void printArr(int[][] arr, int N, int M) {
		int max = Math.max(N, M);
		for (int row = 0; row < max; row++) {
			for (int col = 0; col < max; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}
	
}
