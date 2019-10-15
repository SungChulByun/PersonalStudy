package Line_Online;

import java.util.*;

public class problem2 {
	static Queue<int[]> qu = new LinkedList<int[]>();
	static int[] data, visit;
	static int m;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int target = sc.nextInt();
		String[] num = input.split(" ");
		String answer = "";
		m = num.length;
		data = new int[m];
		visit = new int[m];
		for(int i=0;i<m;i++) {
			data[i]=Integer.parseInt(num[i]);
		}
		Arrays.sort(data);
		int ct=0;
		make(new int[m], 0);
		while(!qu.isEmpty()) {
			int[] tp = qu.poll();
			if(ct+1==target) {
				for(int i=0;i<tp.length;i++) {
					answer+=tp[i];
				}
			}
//			System.out.print((ct+1)+" : ");
//			for(int i=0;i<m;i++) {
//				System.out.print(tp[i]+" ");
//			}
//			System.out.println();
			ct++;
		}
		System.out.println(answer);
		
	}
	
	static void make(int[] x, int loc) {
		if(loc==m) {
			qu.add(x.clone());
		}
		else {
			for(int i=0;i<m;i++) {
				if(visit[i]==1) continue;
				x[loc]=data[i];
				visit[i]=1;
				make(x, loc+1);
				visit[i]=0;
			}
		}
	}
}
