package naver;
import java.util.*;
public class problem1 {
	public static void main(String args[]) {
		String[] r1 = new String[] {"RECEIVE abcd@naver.com", "RECEIVE zzkn@naver.com", "DELETE", "RECEIVE qwerty@naver.com", "SAVE", "RECEIVE QwerTY@naver.com"};
		String[] r2 = new String[] {"RECEIVE abcd@naver.com", "SAVE", "SAVE", "RECEIVE zzkn@naver.com", "DELETE", "RECEIVE qwerty@naver.com", "SAVE", "SAVE", "DELETE", "RECEIVE QwerTY@naver.com", "SAVE", "DELETE", "DELETE"};
		String[] a1 = solution(r1);
		String[] a2 = solution(r2);
		for(int i=0;i<a2.length;i++) {
			System.out.print(a2[i]+" ");
		}
	}
	public static String[] solution(String[] record) {
		ArrayList<String> fin = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		
		int n = record.length;
		for(int i=0;i<n;i++) {
			if(record[i].indexOf("RECEIVE")==0) {
				temp.add(record[i].split(" ")[1]);
			}
			else if(record[i].indexOf("DELETE")==0) {
				if(temp.size()>0) temp.remove(temp.size()-1);
			}
			else if(record[i].indexOf("SAVE")==0) {
				while(!temp.isEmpty()) {
					fin.add(temp.remove(0));
				}
			}
		}
		String[] answer=new String[fin.size()];
		for(int i=0;i<fin.size();i++) {
			answer[i]=fin.get(i);
		}
		return answer;
		
	}
}
