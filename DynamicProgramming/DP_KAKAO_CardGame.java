package DynamicProgramming;

public class DP_KAKAO_CardGame {
	public static void main(String args[]) {
		int[] left = new int[] {3, 3, 2};
		int[] right = new int[] {3, 3, 3};
		int ans = solution(left, right);
		System.out.println(ans);
	}
	public static int solution(int[] left, int[] right) {
        int answer = 0;
        int n = left.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
        	if(right[i-1]<left[0]) {
        		dp[i][0]=dp[i-1][0]+right[i-1];
        	}
        	else {
        		dp[i][0]=-1;
        	}
        	for(int j=1;j<=n;j++) {
        		if(right[i-1]<left[j-1]) {
        			dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]+right[i-1]);
        		}
        		else {
        			dp[i][j]=dp[i][j-1];
        		}
        	}
        }
        answer = dp[n][n];
        if(answer<0) answer=0;
        return answer;
    }
}
