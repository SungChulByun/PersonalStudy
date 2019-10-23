package practice;
import java.util.*;
public class YJask_et {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		long data[] = new long[n];
		long ans[] = new long[m];
		data[0]=sc.nextLong();
		for(int i=1;i<n;i++) {
			data[i]=data[i-1]+sc.nextLong();
		}
		for(int i=0;i<m;i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			if(a==0) ans[i]=data[b];
			else ans[i]=data[b]-data[a-1];
		}
		
		for(int i=0;i<m;i++) {
			if(ans[i]>0) System.out.print("+");
			System.out.println(ans[i]);
		}
	}
}
