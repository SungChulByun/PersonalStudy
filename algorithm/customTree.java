package algorithm;

import java.util.*;
public class customTree {
	static customnode[] tree;
	static int dep, n, yval[];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		dep = sc.nextInt();
		n = (int) Math.pow(2, dep);
		tree = new customnode[2*n];
		
		yval = new int[n+1];
		int tp = 0;
		for(int i=0;i<n+1;i++) {
			yval[i]=tp++;
			if(i%2==0) tp++;
		}
		
		
		for(int i=0;i<2*n;i++) {
			tree[i] = new customnode();
		}
		printTree_width();
		
		update(6, 12, 1);
		printTree();

		
	}
	static int width(int idx) {
		if(idx>=n) {//마지막 줄
			return yval[idx+1-n]-yval[idx-n];
		}
		else {
			return width(idx*2)+width(idx*2+1);
		}
	}
	
	static void renew_add(int idx) {
		int cur = idx;
		if(tree[cur].cnt==0) {
			tree[cur].val=width(idx);
			cur/=2;
			while(cur>0&&tree[cur].cnt==0) {
				tree[cur].val=tree[cur*2].val+tree[cur*2+1].val;
				cur/=2;
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
			else tree[cur].val=tree[cur*2].val+tree[cur*2+1].val;
			cur/=2;
			while(cur>0&&tree[cur].cnt==0) {
				tree[cur].val=tree[cur*2].val+tree[cur*2+1].val;
				cur/=2;
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
				while((((ch>>ct)<<ct)+((int) Math.pow(2, ct))-1<=e)&&((ch>>ct)<<ct)>=s) {
					ct++;
				}
				ct--;
				if(type==1) renew_add((n+s)/((int)Math.pow(2, ct)));
				else renew_minus((n+s)/((int)Math.pow(2, ct)));
				tree[(n+s)/((int)Math.pow(2, ct))].cnt+=type;
				
				update(s+((int)Math.pow(2, ct)), e, type);
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
				System.out.println();
				System.out.println();
				for(int i=0;i<gp/2;i++) System.out.print(" ");
			}
			else {
				for(int i=0;i<gp;i++) System.out.print(" ");
			}
			System.out.print(tree[cur].cnt+","+tree[cur].val);
			cur++;
		}
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

class customnode{
	int cnt, val;
	public customnode() {
		cnt=0;
		val=0;
	}
}