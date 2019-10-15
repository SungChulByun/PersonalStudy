package nhn;

import java.io.*;
import java.util.*;
public class before_pretest {
	static HashMap<String, String> map= new HashMap<String, String>(); // "x, y" , "name" 
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = n/2;
		int maxbox=0;
		int nisodd=0;
		
		int rot = sc.nextInt();
		String name[][] = new String[n][n];
		int boxdata[][] = new int[n][n];
		person pdata[][] = new person[n][n];
		for(int i=0;i<m;i++) {
			boxindexing(boxdata, i);
		}
//		System.out.println();
//		printmap(boxdata);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				name[i][j]=sc.next();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int box;
				if(n%2==1) {
					nisodd=1;
					box =dist(i, j, m, m);
				}
				else {
					box =Math.min(Math.min(dist(i, j, m-1, m-1), dist(i, j, m-1, m)), Math.min(dist(i, j, m, m), dist(i, j, m, m-1)));
				}
				maxbox=Math.max(maxbox, box);
				pdata[i][j]=new person(box, boxdata[i][j], nisodd);
				map.put(toStr(box, boxdata[i][j]), name[i][j]);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if((pdata[i][j].box-maxbox)%2==0) {
					pdata[i][j].rotate(-rot);
				}
				else {
					pdata[i][j].rotate(rot);
				}
//				System.out.print(pdata[i][j].idx+" ");
			}
//			System.out.println();
		}
//		System.out.println();
//		System.out.println("-----len-----");
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(pdata[i][j].len+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println("maxbox : "+maxbox);
		
		printpmap(pdata);
	}
	static void printpmap(person[][] pmap) {
		for(int i=0;i<pmap.length;i++) {
			for(int j=0;j<pmap.length-1;j++) {
				System.out.print(getName(pmap[i][j])+" ");
			}
			System.out.println(getName(pmap[i][pmap.length-1]));
		}
//		System.out.println();
	}
	static String getName(person p) {
		return map.get(toStr(p.box, p.idx));
	}
	static String toStr(int box, int idx) {
		return box+","+idx;
	}
	static void boxindexing(int[][] bdata, int bn) {
		int ct=0;
		int nn = bdata.length;
		for(int i=bn;i<nn-bn;i++) {
			bdata[bn][i]=ct;
			ct++;
		}
		for(int i=bn+1;i<nn-bn;i++) {
			bdata[i][nn-bn-1]=ct;
			ct++;
		}
		for(int i=nn-bn-2;i>=bn;i--) {
			bdata[nn-bn-1][i]=ct;
			ct++;
		}
		for(int i=nn-bn-2;i>=bn+1;i--) {
			bdata[i][bn]=ct;
			ct++;
		}
	}
	static int dist(int x, int y, int tx, int ty) {
		return Math.max(Math.abs(x-tx), Math.abs(y-ty));
	}
	static void printmap(int[][] boxdata) {
		for(int i=0;i<boxdata.length;i++) {
			for(int j=0;j<boxdata[0].length;j++) {
				System.out.print(boxdata[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

class person{
	public int box;
	public int len;
	public int idx;
	
	public person(int box, int idx, int isnodd) {
		this.box=box;
		this.idx=idx;
		if(isnodd==0) this.len=8*box+4;
		else this.len=8*box;
	}
	public void rotate(int x) {
		if(len>0) {
			this.idx+=x;
			while(idx<0) {
				this.idx+=len;
			}
			this.idx=this.idx%this.len;
		}
	}
}