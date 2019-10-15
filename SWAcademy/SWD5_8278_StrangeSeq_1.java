package SWAcademy;
import java.util.Scanner;
public class SWD5_8278_StrangeSeq_1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[][] seq = new int[1000][1000];
		long[][] index = new long[1000][1000];
		int t = sc.nextInt();
		for(int tt=0;tt<t;tt++) {
			long n = sc.nextLong();
			int m =sc.nextInt();
			for(int i=0;i<m;i++) {
				for(int j=0;j<m;j++) {
					seq[i][j]=-1;
					index[i][j]=-1;
				}
			}
			int x=0;
			int y=1;
			long ct=0;
		}
	}
}
