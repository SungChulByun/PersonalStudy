package algorithm;

import java.util.*;
public class SweepLine {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] data = new int[n][2];
		for(int i=0;i<n;i++) {
			data[i][0]=sc.nextInt();
			data[i][1]=sc.nextInt();
		}
		int answer = mindistance(data);
		System.out.println(answer);
	}
	static int mindistance(int[][] data) {
		int n = data.length;
		if(n==1) return -1;
		pair[] pdata = new pair[n];
		for(int i=0;i<n;i++) {
			pdata[i]=new pair(data[i][0], data[i][1], i);
		}
		Arrays.sort(pdata, new XComparator());
		
		return mindist(pdata, 0, n-1);
	}
	static int mindist(pair[] data, int s, int e) {
		if(s==e) return Integer.MAX_VALUE;
		
		int mid = (s+e)/2;
		int d1 = mindist(data, s, mid);
		int d2 = mindist(data, mid+1, e);
		int d3 = (d1<d2)? d1:d2;
		
		pair midpair = data[mid];
		
		for(int i=mid;i>=0;i--) {
//			System.out.println("here s, e : "+s+", "+e+", i : "+i);
			if((midpair.x-data[mid-i].x)>d3) break;
			for(int j=mid+1;j<=e;j++) {
				if((data[j].x-data[i].x)>d3) break;
				d3=Math.min(d3, data[i].dist(data[j]));
//				System.out.println("here s, e : "+s+", "+e+", i, j : "+i+", "+j);
			}
		}
		return d3;
	}
}

class pair{
	int x;
	int y;
	int no;
	
	public pair(int x, int y, int no) {
		this.x=x;
		this.y=y;
		this.no=no;
	}
	
	public int dist(pair a) {
		return (int) (Math.pow(this.x-a.x,2)+Math.pow(this.y-a.y,2));
	}
}
class XComparator implements Comparator<pair>{
	@Override
	public int compare(pair p1, pair p2) {
		return p1.x-p2.x;
	}
}

class YComparator implements Comparator<pair>{
	@Override
	public int compare(pair p1, pair p2) {
		return (p1.y-p2.y);
	}
}