package kakao2;
import java.util.*;
public class s2_stick_1094 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer=0;
		for(int i=0;i<=6;i++) {
			if(((n>>i)&1)==1) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
