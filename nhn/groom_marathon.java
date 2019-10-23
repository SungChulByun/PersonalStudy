package nhn;
import java.util.*;
public class groom_marathon {
	static ArrayList<Integer> list = new ArrayList<Integer>(); 
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		int[] ans = new int[n];
		for(int i=0;i<n;i++) data[i]=sc.nextInt();
		ans[0]=1;
		list.add(data[0]);
		for(int i=1;i<n;i++) {
			ans[i]=loc(data[i]);
		}
		for(int i=0;i<n;i++) {
			System.out.print(ans[i]+" ");
			
		}
	}
	static int loc(int tar) {
		int s = 0;
		int e = list.size()-1;
		while(s<=e) {
			int m = (s+e)/2;
			if(tar>list.get(m)) {
				e=m-1;
			}
			else {
				s=m+1;
			}
		}
		list.add(s, tar);
		return s+1;
	}
}
