package kakao2;
import java.util.*;
public class s3_chess_1018 {
	static int map[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int answer=64;
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			String tp = sc.next();
			for(int j=0;j<m;j++) {
				if(tp.charAt(j)=='B') map[i][j]=0;
				else map[i][j]=1;
			}
		}
		for(int i=0;i<n-7;i++) {
			for(int j=0;j<m-7;j++) {
				int ct=0;
				for(int a=0;a<8;a++) {
					for(int b=0;b<8;b++) {
						if((a+b)%2==0&&map[i+a][j+b]==0) ct++;
						else if((a+b)%2==1&&map[i+a][j+b]==1) ct++;
					}
				}
//				System.out.println("i, j : "+i+", "+j+", ct : "+ct);
				answer=Math.min(answer, Math.min(ct, 64-ct));
				
			}
		}
		
		System.out.println(answer);
	}
}
