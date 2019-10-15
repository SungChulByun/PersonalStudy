package SWAcademy;

import java.util.*;
public class SWD5_8278_StrangeSeq {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] ans = new long[t];
		long[] ter = new long[t];
		for(int tt=0;tt<t;tt++) {
			long n = sc.nextLong();
			long m = sc.nextLong();
			
			if(n>10) {
				HashMap<String, Long> map = new HashMap<String, Long>();
				boolean repeat = false;
				long ct=0;
				long term = 0;
				while(!repeat) {
					String tp = longToString(generate(ct, m), generate(ct+1, m));
					if(map.containsKey(tp)) {
						repeat=true;
						term = ct-map.get(tp);
						ter[tt]=term;
					}
					else {
						map.put(tp, ct);
						ct++;
					}
				}
				long rem = (n-ct)%m;
				ans[tt]=generate(ct+rem, m);
			}
			else {
				ans[tt]=generate(n, m);
			}
		}
		for(int i=0;i<t;i++) {
			System.out.println("#"+(i+1)+" "+ans[i]);
		}
	}
	static String longToString(long x, long y) {
		String tp = "";
		tp=x+","+y;
		return tp;
	}
	static long generate(long n, long m) {
		long x = 0;
		long y = 1;
		while(n>0) {
			long z=(cube(x, m)+cube(y, m))%m;
			x=y;
			y=z;
			n--;
		}
		return x;
	}
	static long cube(long x, long m) {
		return (x*x*x)%m;
	}
}
