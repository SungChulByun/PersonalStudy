package nhn;

import java.util.*;
public class nhn_problem3 {
	static int candy[], fmap[][], n;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		String[] data = str.split(" ");
		int len = data.length;
		fmap = new int[n][n];
		candy = new int[n];
		int ct=0;
		for(int i=0;i<len;i++) {
			char cd = data[i].charAt(0);
			if(cd=='A') card_A(ct%n);
			else if(cd=='J') card_J(ct%n);
			else if(cd=='Q') card_Q();
			else if(cd=='K') {
				card_K(ct%n, Integer.parseInt(data[i+1]));
				i++;
			}
			ct++;
		}
		check(candy);
		
		
	}
	static void check(int[] x) {
		for(int i=0;i<n-1;i++) {
			System.out.print(x[i]+" ");
		}
		System.out.print(x[n-1]);
	}
	static void card_A(int x) {
		candy[x]++;
		int[] temp = follow(x);
		addcandy(temp);
	}
	static void card_J(int x) {
		candy[next(x)]++;
		candy[before(x)]++;
		int[] tp1 = follow(next(x));
		int[] tp2 = follow(before(x));
		int[] temp = gather(tp1, tp2);
		addcandy(temp);
	}
	static void card_Q() {
		for(int i=0;i<n;i++) {
			candy[i]++;
		}
		
	}
	static void card_K(int x, int y) {
		fmap[x][y]=1;
	}
	static int[] follow(int x) {
		int[] visit = new int[n];
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.add(x);
		while(!qu.isEmpty()) {
			int next = qu.poll();
			for(int i=0;i<n;i++) {
				if(visit[i]==0&&fmap[next][i]==1) {
					qu.add(i);
					visit[i]=1;
				}
			}
		}
		return visit;
	}
	static int[] gather(int[] x, int[] y) {
		int[] re = new int[n];
		for(int i=0;i<n;i++) {
			re[i]=Math.max(x[i], y[i]);
		}
		return re;
	}
	static void addcandy(int[] x) {
		for(int i=0;i<n;i++) {
			candy[i]+=x[i];
		}
	}
	static int next(int x) {
		return (x+1)%n;
	}
	static int before(int x) {
		return (x+n-1)%n;
	}
}
