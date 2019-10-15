package kakao2;

import java.util.*;
public class transfer_5214 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		int[] far = new int[n+1];
		for(int i=1;i<=n;i++) {
			far[i]=n+2;
		}
		far[1]=1;
		String[] data = new String[m];
		for(int i=0;i<m;i++) {
			String tp="";
			for(int j=0;j<k;j++) {
				tp+=sc.nextInt();
			}
			data[i]=tp;
		}
		Arrays.sort(data);
		
		boolean operating=true;
		while(operating) {
			operating=false;
			int before=0;
			for(int i=1;i<=n;i++) before+=far[i];
			for(int i=0;i<m;i++) {
				int min=n;
				for(int j=0;j<k;j++) {
//					System.out.print((data[i].charAt(j)-'0')+" ");
					min = Math.min(far[data[i].charAt(j)-'0'], min);
				}
//				System.out.println();
//				for(int j=1;j<=n;j++) {
//					System.out.print(far[j]+" ");
//				}
//				System.out.println("min : "+min);
				for(int j=0;j<k;j++) {
					if(data[i].charAt(j)-'0'==1) continue;
					far[data[i].charAt(j)-'0']=min+1;
				}
			}
			int after=0;
			for(int i=1;i<=n;i++) after+=far[i];
			if(after!=before) operating=true;
		}
		System.out.println(far[n]);
	}
}
