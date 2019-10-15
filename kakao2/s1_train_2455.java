package kakao2;

import java.util.*;
public class s1_train_2455 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int in[] = new int[4];
		int out[] = new int[4];
		for(int i=0;i<4;i++) {
			out[i]=sc.nextInt();
			in[i]=sc.nextInt();
		}
		int answer=0;
		int cur=0;
		for(int i=0;i<4;i++) {
			cur-=out[i];
			cur+=in[i];
			if(cur>10000) cur=10000;
			answer=Math.max(cur, answer);
		}
		System.out.println(answer);
	}
}