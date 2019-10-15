package naver;
import java.util.*;
public class problem2 {
	static ArrayList<ArrayList<Long>> mainlst = new ArrayList<ArrayList<Long>>();
	static PriorityQueue<Long> qu = new PriorityQueue<Long>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		if(n==1) {
			System.out.println("answer : "+2);
			return;
		}
		qu.add((long) 2);
		ArrayList<Long> tp1 = new ArrayList<Long>();
		tp1.add((long) 2);
		mainlst.add(tp1);
		while(qu.size()<n) {
			addnum(0);
			long std = mainlst.get(0).get(mainlst.get(0).size()-1); 
			addqu(std);
			for(int i=1;i<mainlst.size();i++) {
				long tp = mainlst.get(i).get(mainlst.get(i).size()-1);
				if(tp<=std) {
					addqu(tp);
					addnum(i);
				}
			}
			if(mainlst.get(mainlst.size()-1).size()>=2) {
				
				long tp = mainlst.get(mainlst.size()-1).get(1);
//				System.out.println("here1 tp : "+tp);
				if(tp<=std) {
					addqu(tp);
					addnum(mainlst.size());
				}
			}
		}
		long ans = 0;
		for(int i=0;i<n;i++) {
			ans = qu.poll();
			System.out.println("i, answer : "+i+", "+ans);
		}
		
		printans();
	}
	static void printans() {
		for(int i=0;i<mainlst.size();i++) {
			for(int j=0;j<mainlst.get(i).size();j++) {
				System.out.print(mainlst.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	static void addqu(long x) {
		if(!qu.contains(x)) {
			qu.add(x);
		}
	}
	static void addnum(int i) {
		if(mainlst.size()==i) {
			ArrayList<Long> temp = new ArrayList<Long>();
			temp.add(mainlst.get(i-1).get(1));
			mainlst.add(temp);
		}
		else {
			int sz = mainlst.get(i).size();
			mainlst.get(i).add(mainlst.get(i).get(sz-1)*(i+2+sz)/sz);
		}
	}
}