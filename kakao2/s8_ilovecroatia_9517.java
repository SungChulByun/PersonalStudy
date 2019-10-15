package kakao2;

import java.util.*;
import java.io.*;
public class s8_ilovecroatia_9517 {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int n = sc.nextInt();
		int ct=0;
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=sc.nextInt();
			if(sum>=210) {
				break;
			}
			else if(sc.next().charAt(0)=='T') ct++;
		}
		int answer = (start+ct)%8;
		if(answer==0) answer=8;
		System.out.println(answer);
		
	}

}
