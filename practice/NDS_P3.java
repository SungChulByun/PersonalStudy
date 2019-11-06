package practice;
import java.util.*;
public class NDS_P3 {
	static Queue<int[]> qu = new LinkedList<int[]>();
	static HashSet<String> set = new HashSet<String>();
	static int size[], tar;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		size = new int[3];
		for(int i=0;i<3;i++) size[i] = sc.nextInt();
		tar = sc.nextInt();
		int ans = 0;
		qu.add(new int[] {0, 0, 0, 0});
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			if(check(cur)||cur[3]>=500) {
//				printlist(cur);
				ans = cur[3];
				qu.clear();
				break;
			}
			else {
				for(int i=0;i<3;i++) {
					int[] tp1 = fill(cur,i);
					if(!set.contains(makestatus(tp1))) {
//						System.out.println("fill "+i);
//						printlist(tp1);
						qu.add(tp1);
						addStatus(tp1);
					}
					int[] tp2 = remove(cur, i);
					if(!set.contains(makestatus(tp2))) {
//						System.out.println("remove "+i);
//						printlist(tp2);
						qu.add(tp2);
						addStatus(tp2);
					}
				}
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						
						if(i!=j) {
//							System.out.println("here : "+i+", "+j);
							int[] tp = move(cur, i, j);
//							printlist(tp);
							if(!set.contains(makestatus(tp))) {
//								System.out.println("move from : "+i+", to : "+j);
//								printlist(tp);
								qu.add(tp);
								addStatus(tp);
							}
						}
					}
				}
			}
		}
		if(ans==0) System.out.println(-1);
		else System.out.println(ans);
	}
	static String makestatus(int[] cur) {
		return ""+cur[0]+","+cur[1]+","+cur[2];
	}
	static void addStatus(int[] cur) {
		set.add(makestatus(cur));
	}
	static void printlist(int[] list) {
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]+" ");
		}
		System.out.println();
	}
	static int[] fill(int[] cur, int loc) {
		int[] re = new int[4];
		for(int i=0;i<3;i++) {
			re[i]=cur[i];
		}
		re[3]=cur[3]+1;
		re[loc] = size[loc];
		return re;
	}
	static int[] remove(int[] cur, int loc) {
		int[] re = new int[4];
		for(int i=0;i<3;i++) {
			re[i]=cur[i];
		}
		re[3]=cur[3]+1;
		re[loc] = 0;
		return re;
	}
	static int[] move(int[] cur, int from, int to) {
		int[] re = new int[4];
		for(int i=0;i<3;i++) {
			re[i]=cur[i];
		}
		re[3]=cur[3]+1;
		if(re[from]+re[to]>size[to]) {
			re[from] = re[from]+re[to]-size[to];
			re[to] = size[to];
		}
		else {
			re[to]+=re[from];
			re[from]=0;
		}
		return re;
	}
	static boolean check(int[] cur) {
		for(int i=0;i<3;i++) {
			if(cur[i]==tar) return true;
		}
		return false;
	}
}
