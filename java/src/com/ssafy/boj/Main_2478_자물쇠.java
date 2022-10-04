package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//미완
public class Main_2478_자물쇠 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int[] arr = new int[N];
		int[] tmp = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans3 = 1;
		int ans2p = 0;
		int ans2q = 0;
		int ans1 = 0;
		int cnt = 0;
		boolean isFound = false;
		boolean endFlag = false;
		for (; ans3 < N; ans3++) {
			isFound = false;
			endFlag = false;
			cnt = 0;
			tmp = Arrays.copyOf(arr, arr.length);
			pushRight(tmp, ans3);
			for (int idx = 0; idx < N - 1; idx++) {
				if (tmp[idx] - 1 == (tmp[idx + 1] - 1 + 1) % 10) {
					cnt++;
					if (!isFound) {
						isFound = true;
						ans2p = idx;
					}
				} else if (tmp[idx] - 1 == (tmp[idx + 1] - 1 - 1) % 10) {
					continue;
				} else {
					if (endFlag) {
						break;						
					}
					if (isFound) {
						endFlag = true;
					}
				}
			}
//			System.out.println(Arrays.toString(tmp));
//			System.out.println("ans3: " + ans3 + ", isFound: " + isFound + ", ans2p: " + ans2p + ", cnt: " + cnt);
			if (!isFound || endFlag) {
				continue;
			} else {
				break;
			}
		}
		ans2q = ans2p + cnt;
		ans2p++;
		ans2q++;
		pushRight(arr, ans3);
//		System.out.println(ans3);
//		System.out.println(Arrays.toString(arr));
		reverse(arr, ans2p, ans2q);
//		System.out.println(Arrays.toString(arr));
		
		for (int i = 0; i < N; i++) {
			if (arr[i] == 1) {
				ans1 = N - i;
				break;
			}
		}
		pushRight(arr, ans1);
		System.out.println(Arrays.toString(arr));
		System.out.println(ans1);
		System.out.println(ans2p + " " + ans2q);
		System.out.println(ans3);
	}

	public static void pushRight(int[] arr, int k) {
		int[] temp = new int[arr.length];
		int i = 0;
		for (i = 0; i < k; i++) {
			temp[i] = arr[arr.length - k + i];
		}
		
		int putIdx = arr.length - 1;
		for (i = arr.length - k - 1; i >= 0; i--) {
			arr[putIdx--] = arr[i];
		}
		for (i = 0; i < k; i++) {
			arr[i] = temp[i];
		}
	}
	
	public static void reverse(int[] arr, int p, int q) {
		int temp = 0;
		for (; p < q; p++, q--) {
			temp = arr[p-1];
			arr[p - 1] = arr[q - 1];
			arr[q - 1] = temp;
		}
	}
}
