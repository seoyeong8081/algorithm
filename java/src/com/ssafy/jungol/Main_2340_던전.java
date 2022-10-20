package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2340_던전 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N, H;
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		long ans = 0;
		
		int hp = H;
		int besth = 0;
		int besthdiff = 0;
		int di, hi;
		
		int mtmp = 0;
		int plustmp = 0;
		int dtmp = 0;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			di = Integer.parseInt(st.nextToken());
			hi = Integer.parseInt(st.nextToken());
			
			if (besth < hi) {
				besth = hi;
				besthdiff = H - hp;
				mtmp = (besthdiff - 1) / besth;
				dtmp = besthdiff - mtmp * besth;
				plustmp = Math.min(dtmp, hi);
			} else {
				dtmp += di;
				plustmp = Math.max(plustmp, Math.min(dtmp, hi));
			}
			hp -= di;
			
//			if (i == N - 2) { // debugging
//				System.out.println(hp + " " + besth + " " + besthdiff);
//			}
			if (hp <= 0) {
				// 여기서 최소한만 채워야 할 지
				// 최소한으로 채우면,,, 최적이 아닐듯???
				// 만땅으로 채워지면 다음hi기준으로???
				
				// best hi를 메모해야하는지
				// hi - di?
				// 누적 di?
				
				// best hi에서 최대 hp까지 채워졌다면
				// 다음 hi를 찾아야함
				int m = ( -hp / besth ) + 1;
				int plus = m * besth;
				if (plus > besthdiff) {
//					m = ((besthdiff - 1) / besth) + 1;
//					plus = besthdiff;
					m = mtmp + 1;
					plus = mtmp * besth + plustmp;
				}
				
				hp += plus;
				ans += m;
				besth = 0;
			}
//			System.out.println(ans + " " + hp); // 마지막 3에서 +1해서 5 나와야하는데
//			System.out.println(dtmp + " " + plustmp + " " + mtmp); // 마지막 3에서 +1해서 5 나와야하는데
		}
		
		System.out.println(ans);
	}
	
}
