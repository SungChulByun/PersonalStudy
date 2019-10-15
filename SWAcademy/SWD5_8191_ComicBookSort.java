package SWAcademy;
import java.util.*;
public class SWD5_8191_ComicBookSort {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int ans[] = new int[t];
		for(int tc=0;tc<t;tc++) {
			int n = sc.nextInt();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int i=0;i<n;i++) {
				map.put(sc.nextInt(), i);
			}
			int ct=0;
			for(int i=n;i>=2;i--) {
				if(map.get(i)<map.get(i-1)) ct++;
			}
			ans[tc]=ct+1;
		}
		for(int i=0;i<t;i++) System.out.println("#"+(i+1)+" "+ans[i]);
	}
}
