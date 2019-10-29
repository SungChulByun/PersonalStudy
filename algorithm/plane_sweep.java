package algorithm;
import java.util.*;
public class plane_sweep {
	static HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
	static PriorityQueue<Integer> pqu = new PriorityQueue<Integer>();
	static Tree tr;
	public static void main(String args[]) {
		int[][] rec1 = new int[][] {};
		int[][] rec2 = new int[][] {{1, 1, 6, 5}, {2, 0, 4, 2}, {2, 4, 5, 7}, {4, 3, 8, 6}, {7, 5, 9, 7}};
		long ans1 = solution(rec1);
		long ans2 = solution(rec2);
		System.out.println(ans1);
		System.out.println(ans2);
	}
	public static long solution(int[][] rec) {
		long answer=0;
		int n = rec.length;
		line[] linelist = new line[2*n];
		for(int i=0, sx, sy, ex, ey ;i<n;i++) {
			sx=rec[i][0];
			sy=rec[i][1];
			ex=rec[i][2];
			ey=rec[i][3];
			line sline = new line(sx, sy, ey, 1);
			line eline = new line(ex, sy, ey, -1);
			if(!pqu.contains(sy)) pqu.add(sy);
			if(!pqu.contains(ey)) pqu.add(ey);
			linelist[2*i]=sline;
			linelist[2*i+1]=eline;
		}
		Arrays.sort(linelist);
		
		int ct=0;
		int nodenum = pqu.size();
		int before=pqu.peek();
		tr = new Tree(nodenum);
		
		while(!pqu.isEmpty()) {
			int cur = pqu.poll();
			index.put(cur, ct);
			if(ct>0) {
				tr.addData(ct-1, cur-before);
			}
			before=cur;
			ct++;
		}
		for(int i=0;i<linelist.length;i++) {
			if(i>0) {
				answer+=(tr.val)*(linelist[i].x-linelist[i-1].x);
			}
			if(linelist[i].status==1) {
				int syidx = index.get(linelist[i].sy);
				int eyidx = index.get(linelist[i].ey);
				for(int j=syidx;j<eyidx;j++) {
					tr.countPlus(j);
				}
			}
			else {
				int syidx = index.get(linelist[i].sy);
				int eyidx = index.get(linelist[i].ey);
				for(int j=syidx;j<eyidx;j++) {
					tr.countMinus(j);
				}
			}
		}
		return answer;
	}
}
class Tree{
	int data[], count[];
	long val;
	public Tree(int x) {
		data = new int[x-1];
		count = new int[x-1];
		val=0;
	}
	public void addData(int loc, int len) {
		data[loc]=len;
	}
	public void countPlus(int loc) {
		if(count[loc]==0) val+=data[loc];
		count[loc]++;
	}
	public void countMinus(int loc) {
		if(count[loc]==1) val-=data[loc];
		count[loc]--;
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