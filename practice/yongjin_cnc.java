package practice;
import java.util.*;
public class yongjin_cnc {
	static int dp[][], n, tar;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int data[] = new int[n];
		for(int i=0;i<n;i++) data[i]=sc.nextInt();
		tar = sc.nextInt();
		dp = new int[n][tar+1];
		for(int i=0;i<n;i++) dp[i][0]=1;
		dp[0][data[0]]=1;
		for(int i=1;i<n;i++) {
			for(int j=0;j<=tar;j++) {

				dp[i][j] = dp[i-1][j];
				if(j-data[i]>=0) dp[i][j]+=dp[i-1][j-data[i]];
			}
		}
		System.out.println(dp[n-1][tar]);
		printdp();
	}
	static void printdp() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<=tar;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}
}
