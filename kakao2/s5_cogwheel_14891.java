package kakao2;

import java.util.*;
public class s5_cogwheel_14891 {
	static String st[];
	static int data[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		st = new String[4];
		for(int i=0;i<4;i++) {
			st[i]=sc.next();
		}
		int rt = sc.nextInt();
		data = new int[rt][2];
		for(int i=0;i<rt;i++) {
			data[i][0]=sc.nextInt()-1;
			data[i][1]=sc.nextInt();
		}
		for(int i=0;i<rt;i++) {
//			System.out.println((i+1)+"th");
			operate(i);
			
//			for(int j=0;j<4;j++) {
//				System.out.println(st[j]);
//			}
//			System.out.println();
		}
		int score = 0;
		for(int i=0;i<4;i++) {
//			System.out.println(st[i]);
			if(st[i].charAt(0)=='1') {
				int tp = (1<<i);
//				System.out.println("i : "+i+", score : "+tp);
				score+=tp;
			}
		}
		System.out.println(score);
	}
	static void rot(int ax, int dir) {
		String tp = "";
		String x = st[ax];
		if(dir==1) {
			tp+=x.charAt(7);
			tp+=x.substring(0, 7);
		}
		else {
			tp=x+x.charAt(0);
			tp=tp.substring(1);
		}
		st[ax] = tp;
	}
	static void operate(int x) {
		int ax = data[x][0];
		int dir = data[x][1];
//		System.out.println((ax+1)+", "+dir);
		if(ax==0) {
			if(isRel(0)) {
				if(isRel(1)) {
					if(isRel(2)) {
						rot(0, dir);
						rot(1, -dir);
						rot(2, dir);
						rot(3, -dir);
					}
					else {
						rot(0, dir);
						rot(1, -dir);
						rot(2, dir);
					}
				}
				else {
					rot(0, dir);
					rot(1, -dir);
				}
			}
			else {
				rot(0, dir);
			}
		}
		else if(ax==1) {
			if(isRel(0)) {
				rot(0, -dir);
			}
			if(isRel(1)) {
				if(isRel(2)) {
					rot(2, -dir);
					rot(3, dir);
				}
				else {
					rot(2, -dir);
				}
			}
			rot(1, dir);
		}
		else if(ax==2) {
			if(isRel(2)) {
				rot(3, -dir);
			}
			if(isRel(1)) {
				if(isRel(0)) {
					rot(1, -dir);
					rot(0, dir);
				}
				else {
					rot(1, -dir);
				}
			}
			rot(2, dir);
		}
		else {
			if(isRel(2)) {
				if(isRel(1)) {
					if(isRel(0)) {
						rot(2, -dir);
						rot(1, dir);
						rot(0, -dir);
					}
					else {
						rot(2, -dir);
						rot(1, dir);
					}
				}
				else {
					rot(2, -dir);
				}
			}
			rot(3, dir);
		}
	}
	static boolean isRel(int x) {
		if(st[x].charAt(2)!=st[x+1].charAt(6)) return true;
		else return false;
	}
}
