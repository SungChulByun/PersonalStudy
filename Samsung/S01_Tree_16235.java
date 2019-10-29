package Samsung;

import java.util.*;
public class S01_Tree_16235 {
	static Trees[][] map;
	static int dx[] = new int[] {-1, -1, 0, 1, 1, 1, 0, -1},
			   dy[] = new int[] {0, 1, 1, 1, 0, -1, -1, -1},
			   n, m, k, energy[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		map = new Trees[n][n];
		energy = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				energy[i][j]=sc.nextInt();
				Trees tp = new Trees(i, j, 5);
				map[i][j]=tp;
			}
		}
		for(int i=0;i<m;i++) {
			map[sc.nextInt()-1][sc.nextInt()-1].addTree(sc.nextInt());
		}
		for(int year=0;year<k;year++) {
//			System.out.println("------------"+(year+1)+"------------");
//			System.out.print("1, 1 tree ages : ");
//			for(int i=0;i<map[1][1].age.length;i++) {
//				System.out.print(map[1][1].age[i]+" ");
//			}
//			System.out.println();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					spring(i, j);
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					fall(i, j);
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j].addEnergy(energy[i][j]);
				}
			}
		}
		int ans = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ans+=map[i][j].num;
//				System.out.print(map[i][j].energy+" ");
//				if(map[i][j].num>0)	System.out.print(map[i][j].age[0]+" ");
//				else System.out.print("0 ");
			}
//			System.out.println();
		}
		System.out.println(ans);
	}
	static void spring(int x, int y) {
		Trees tp = map[x][y];
		for(int i=0;i<tp.age.length;i++) {
			if(tp.energy>=tp.age[i]) {
				tp.energy-=tp.age[i];
				tp.age[i]++;
			}
			else {
				tp.num=i;
				break;
			}
		}
		for(int i=tp.num;i<tp.age.length;i++) {
//			System.out.println("die "+x+", "+y);
			tp.energy+=tp.age[i]/2;
			tp.age[i]=0;
		}
		tp.age = tp.newAge(tp.num);
	}
	static void fall(int mx, int my) {
		Trees tp = map[mx][my];
		
		int ct=0;
		for(int i=0;i<tp.age.length;i++) {
			if(tp.age[i]%5==0) ct++;
		}
		if(ct>0) {
//			System.out.println("x, y : "+mx+", "+my+", tree age : "+tp.age[tp.age.length-1]);
		}
		for(int i=0;i<8;i++) {
			int nx = tp.x+dx[i];
			int ny = tp.y+dy[i];
			if(nx>=0&&nx<n&&ny>=0&&ny<n) {
				for(int j=0;j<ct;j++) {
					map[nx][ny].addTree(1);
//					System.out.println("add tree : "+nx+", "+ny);
				}
			}
		}
	}
}

class Trees{
	public int x, y;
	public int num;
	public int[] age;
	public int energy;
	
	public Trees(int x, int y, int en) {
		this.x=x;
		this.y=y;
		this.num=0;
		this.age = new int[] {};
		this.energy=en;
	}
	public void addEnergy(int en) {
		this.energy+=en;
	}
	public void addTree(int old) {
		this.num++;
		addOne(old);
	}
	private void addOne(int x) {
		int[] re = new int[age.length+1];
		for(int i=0;i<age.length;i++) {
			re[i]=age[i];
		}
		re[age.length]=x;
		Arrays.sort(re);
		age = re;
	}
	
	public int[] newAge(int x) {
		int[] re = new int[x];
		for(int i=0;i<x;i++) {
			re[i] = this.age[i];
		}
		return re;
	}
	
}
