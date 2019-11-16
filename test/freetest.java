package test;
import java.util.*;
public class freetest {
	static int[] data;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = 30;
		data = new int[n];
		
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
		int ans=0;
		for(int i=0;i<n;i++) {
			for(int j=1;j<=n-i;j++) {
				ans+=check(i, j);
				
			}
		}
		System.out.println(ans);
	}
	static int check(int start, int num) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=start; i<start+num;i++) {
			set.add(data[i]);
		}
		if(set.size()==num) return 1;
		else return 0;
	}
}