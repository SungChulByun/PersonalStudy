package binarysearch;

import java.util.*;
public class b3_snail_climb_2869 {
	static long a, b, h, answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextLong();
		b = sc.nextLong();
		h = sc.nextLong();
		answer=0;
		long max = h/(a-b)+1;
		long min = 0;
		dfs(max, min);
		System.out.println(answer);
	}
	static void dfs(long top, long bot) {
		if(top-bot==1) {
			if((bot-1)*(a-b)+a>h) {
				answer=bot;
			}
			else answer=top;
			return;
		}
		else {
			long day = (top+bot)/2;
			if((day-1)*(a-b)+a>=h) {
				dfs(day, bot);
			}
			else {
				dfs(top, day);
			}
			
		}
	}
}
