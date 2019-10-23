package nhn;
import java.util.*;
public class bridge {	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int data[] = new int[n];
		for(int i=0;i<n;i++) data[i]=sc.nextInt();
		Arrays.sort(data);
		int dp[] = new int[n+2];
		dp[0]=data[0];
		dp[1]=data[1];
		dp[2]=data[0]+data[1]+data[2];
		for(int i=3;i<n;i++) {
			int dif=Math.min(data[0]+2*data[1]+data[i], 2*data[0]+data[i-1]+data[i]);
			dp[i]=dp[i-2]+dif;
		}
		System.out.println(dp[n-1]);
	}
}