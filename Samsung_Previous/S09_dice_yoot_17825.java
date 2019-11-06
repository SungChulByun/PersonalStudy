package Samsung_Previous;
import java.util.*;
public class S09_dice_yoot_17825 {
	static Queue<int[]> qu = new LinkedList<int[]>();
	static int dice[], score[];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		dice = new int[10];
		score = new int[] {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20,
						   22, 24, 26, 28, 30, 32, 34, 36, 38, 40,
						   13, 16, 19, 22, 24, 28, 27, 26, 25, 30, 35, 0};
		for(int i=0;i<10;i++) {
			dice[i]=sc.nextInt();
		}
		
		int ans = 0;
		int[] start = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		qu.add(start);
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			int loc = cur[4];
			int curscore = cur[5];
//			if((cur[6]==12221&&cur[7]==2112)||(cur[6]==12221&&cur[7]==211)||(cur[6]==12221&&cur[7]==21)||(cur[6]==12221&&cur[7]==2)||(cur[6]==12221&&cur[7]==0)||(cur[6]==1222&&cur[7]==0)||(cur[6]==122&&cur[7]==0)||(cur[6]==12&&cur[7]==0)||(cur[6]==1&&cur[7]==0)) {
//				printlist(cur);
//			}
			if(loc==10) {
//				if(curscore==203||curscore==190) {
//					printlist(cur);
//					System.out.println("--score : "+curscore);
//				}
				ans = Math.max(ans, curscore);
			}
			else {
				for(int i=0;i<4;i++) {
					int tp[] = cur.clone();
					if(tp[i]!=32) {
						int nxt = next(tp[i], dice[loc]);
						boolean check=true;
						for(int j=0;j<4;j++) {
							if(i!=j) {
								if(tp[j]==nxt&&nxt!=32) check = false;
							}
						}
						if(check) {
							if(loc<=4) {
								tp[6]*=10;
								tp[6]+=i+1;
							}
							else {
								tp[7]*=10;
								tp[7]+=(i+1);
							}
							tp[i]=next(tp[i], dice[loc]);
							tp[5] +=score[tp[i]];
							tp[4]++;
							qu.add(tp);
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
	static void printlist(int[] lst) {
		for(int i=0;i<lst.length;i++) {
			System.out.print(lst[i]+" ");
		}
		System.out.println();
	}
	static int next(int x, int d) {
		if(d==0) return x;
		else {
			if(x==4&&d>1) return next(6, d-2);
			else if(x==5) return next(21, d-1);
			else if(x==9&&d>1) return next(11, d-2);
			else if(x==10) return next(24, d-1);
			else if(x==14&&d>1) return next(16, d-2);
			else if(x==15) return next(26, d-1);
			else if(x==23) return next(29, d-1);
			else if(x==25) return next(29, d-1);
			else if(x==31) return next(20, d-1);
			else if(x==20) return next(32, 0);
			else return next(x+1, d-1);
		}
	}
}
