package Line_Online;

import java.util.*;
public class problem4 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ct=0;
		int max=0;
		int left=0;
		boolean firstone=false;
		int[] data = new int[n];
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
			if(data[i]==0) {
				if(!firstone) left++;
				ct++;
			}
			else {
				ct=0;
				firstone=true;
			}
			max=Math.max(ct, max);
		}
		if(max==ct) {
			System.out.println(+ct);
		}
		else if(max==left) {
			System.out.println(left);
		}
		else {
			System.out.println((max+1)/2);
		}
	}
}
