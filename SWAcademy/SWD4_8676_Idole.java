package SWAcademy;
import java.util.*;
public class SWD4_8676_Idole {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int div = 1000000007;
		int t = sc.nextInt();
		int ans[] = new int[t];
		String sam = "SAMSUNG";
		for(int tc=0;tc<t;tc++) { // SAMSUNG
			String str = sc.next();
			int dp[][] = new int[str.length()][7];
			dp[0][0]=1;
			for(int i=1;i<str.length();i++) {
				char tp = str.charAt(i);
				for(int j=0;j<7;j++) {
					dp[i][j]=dp[i-1][j]%div;
				}
				if(tp=='S') {
					dp[i][0]=(dp[i-1][0]+1)%div;
					dp[i][3]=(dp[i-1][3]+dp[i-1][2])%div;
				}
				else if(sam.indexOf(tp)!=-1) {
					int loc = sam.indexOf(tp);
					dp[i][loc] = (dp[i-1][loc-1]+dp[i-1][loc])%div;
				}
			}
			ans[tc] = dp[str.length()-1][6]%div;
		}
		for(int i=0;i<t;i++) System.out.println("#"+(i+1)+" "+ans[i]);
	}
	
}
