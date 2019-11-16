package algorithm;
import java.util.*;
public class plane_sweep_tree {
	static node[] tree;
	static int dep, n, yval[];
	static long update_time;
	public static void main(String args[]) {
		int type = 2;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] rec = new int[n][4];
		for(int i=0;i<n;i++) {
			int[] r = new int[4];
			r[0]=sc.nextInt();
			r[1]=sc.nextInt();
			r[2]=sc.nextInt();
			r[3]=sc.nextInt();
			rec[i]=r;
		}
		long ans = solution(rec);
		System.out.println(ans);
		
		if(type==1) {
			int[][] rec1 = new int[][] {{0, 1, 4, 4}, {3, 1, 5, 3}};
			int[][] rec2 = new int[][] {{1, 1, 6, 5}, {2, 0, 4, 2}, {2, 4, 5, 7}, {4, 3, 8, 6}, {7, 5, 9, 7}};
			System.out.println("ans1 : "+solution(rec1));
			System.out.println("ans2 : "+solution(rec2));
		}
		
	}
	static long solution(int[][] rec) {
		update_time=0;
		long ans = 0;
		int len = rec.length;
		n = 1;
		dep=0;
		while(n<2*len-1) {
			n=n<<1;
			dep++;
		}
		tree = new node[n<<1];
		for(int i=0;i<n<<1;i++) tree[i] = new node();
		yval = new int[len<<1];
		line[] list = new line[len<<1];
		for(int i=0;i<len;i++) {
			list[2*i] = new line(rec[i][0], rec[i][1], rec[i][3], 1);
			list[2*i+1] = new line(rec[i][2], rec[i][1], rec[i][3], -1);
			yval[2*i] = rec[i][1];
			yval[2*i+1] = rec[i][3];
		}
		Arrays.sort(list);
		Arrays.sort(yval);
		for(int i=0;i<len<<1;i++) {
			
			if(i>0) {
				ans+=((long)(list[i].x-list[i-1].x))*((long)(tree[1].val));
			}
			
			int type = list[i].status;
			long start = System.currentTimeMillis();
			update(findidx(list[i].sy), findidx(list[i].ey)-1, type);
			long end = System.currentTimeMillis();
			
			update_time+=(end-start);
//			System.out.print("x : "+list[i].x);
//			System.out.print(" sy : "+list[i].sy);
//			System.out.print(" ey : "+list[i].ey);
//			System.out.println(" type : "+list[i].status);
//			System.out.println("area : "+ans);
//			printTree();
		}
		System.out.println("time : "+update_time);
		return ans;
	}
	static int findidx(int y) {
		int s = 0;
		int e = yval.length;
		int m = (s + e)>>1;
		while (s <= e || yval[m] != y) {
			m = (s + e)>>1;
			if (yval[m] > y) {
				e = m - 1;
			}
			else if (yval[m] < y) {
				s = m + 1;
			}
			else break;
		}
		return m;
	}
	
	static int width(int idx) {
		if(idx>=n) {//마지막 줄
			if(idx+1-n>=yval.length) return 0;
			else return yval[idx+1-n]-yval[idx-n];
		}
		else {
			return width(idx<<1)+width((idx<<1)+1);
		}
	}
	
	static void renew_add(int idx) {
		int cur = idx;
		if(tree[cur].cnt==0) {
			tree[cur].val=width(idx);
			cur/=2;
			while(cur>0&&tree[cur].cnt==0) {
				tree[cur].val=tree[cur<<1].val+tree[(cur<<1)+1].val;
				cur=cur>>1;
			}
		}
//		tree[idx].cnt+=type;
	}
	static void renew_minus(int idx) {
		int cur = idx;
		if(tree[cur].cnt==1) {
			if(cur>=n) {
				tree[cur].val=0;
			}
			else tree[cur].val=tree[cur<<1].val+tree[(cur<<1)+1].val;
			cur=cur>>1;
			while(cur>0&&tree[cur].cnt==0) {
				tree[cur].val=tree[cur<<1].val+tree[(cur<<1)+1].val;
				cur=cur>>1;
			}
		}
//		tree[idx].cnt+=type;
	}
	
	static void update(int s, int e, int type) {
		if(s>e) return;
		else if(s==e) {
			if(type==1)	renew_add(n+s);
			else renew_minus(n+s);
			tree[n+s].cnt+=type;
		}
		else {
			if((s&1)==1) {
				if(type==1)	renew_add(n+s);
				else renew_minus(n+s);
				tree[n+s].cnt+=type;
				update(s+1, e, type);
			}
			else {
				int ch=s, ct=0;
				int num=1;
				int standard = 524287;
				
				while(((ch&standard)+num-1<=e)&&(ch&standard)>=s) {
					ct++;
					num = (num<<1);
					standard = standard<<1;
				}
				ct--;
				num=(num>>1);
				int tp = (1<<ct);
				int tpp = (n+s)/tp;
				if(type==1) renew_add(tpp);
				else renew_minus(tpp);
				tree[tpp].cnt+=type;
				update(s+tp, e, type);
			}
		}
	}
	static void printTree() {
		int cur = 1;
		int d = 0;
		int gp = gap(d);
		while(cur<tree.length) {
			if(cur==(1<<d)) {
				gp=gap(d);
				d++;
				if(cur>1) {
					System.out.println();
					System.out.println();
				}
				for(int i=0;i<gp/2;i++) System.out.print(" ");
			}
			else {
				for(int i=0;i<gp;i++) System.out.print(" ");
			}
			System.out.print(tree[cur].cnt+","+tree[cur].val);
			cur++;
		}
		System.out.println();
		for(int i=0;i<yval.length;i++) {
			System.out.print(yval[i]);
			for(int j=0;j<gp+1;j++) System.out.print(" ");
			if(i>0) System.out.print(" ");
			
		}
		System.out.println();
		System.out.println();
	}
	
	static void printTree_width() {
		int cur = 1;
		int d = 0;
		int gp = gap(d);
		while(cur<tree.length) {
			if(cur==(1<<d)) {
				gp=gap_wid(d);
				d++;
				System.out.println();
				System.out.println();
				for(int i=0;i<gp/2;i++) System.out.print(" ");
			}
			else {
				for(int i=0;i<gp;i++) System.out.print(" ");
			}
			System.out.print(width(cur));
			cur++;
		}
		
	}
	
	static int gap(int d) {
		int lv = dep-d;
		int re =(int) Math.pow(2, lv+2)-1; 
		re*=3;
		re-=(int) Math.pow(2, lv+2);
		return re;
	}
	static int gap_wid(int d) {
		int lv = dep-d;
		int re =(int) Math.pow(2, lv+2)-1; 
		return re;
	}
}
class line implements Comparable<line>{
	int x, sy, ey, status;
	public line(int x, int sy, int ey, int st) {
		this.x=x;
		this.sy=sy;
		this.ey=ey;
		this.status=st;
	}
	@Override
	public int compareTo(line tp) {
		return (this.x-tp.x);
	}
}

class node{
	int cnt, val;
	public node() {
		cnt=0;
		val=0;
	}
}