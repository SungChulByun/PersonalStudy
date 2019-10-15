package kakao;
import java.util.*;
public class shuttle {
	public static void main(String args[]) {
		int[] test = new int[] {2, 10, 2};
		String[] table = new String[] {"24:00", "24:00", "24:00", "24:00"};
		System.out.println(solution(test[0], test[1], test[2], table));
	}
	public static String solution(int n, int t, int m, String[] timetable) {
		Queue<Integer> qu = new LinkedList<Integer>();
		String answer = "";
		int p = timetable.length;
		int[] table = new int[p];
		String[] tb = timetable.clone();
		Arrays.sort(tb);
		for(int i=0;i<p;i++) {
			table[i]=stringtoint(tb[i]);
		}
		int[] bus = new int[n];
		int[] kakao = new int[n];
		int[] kakaotime = new int[n];
		for(int i=0;i<n;i++) {
			bus[i]=540+t*i;
		}
		int i=0;
		while(i<n) {
			int time = bus[i];
			int pretime=0;
			if(i>0) {
				pretime = bus[i-1];
			}
			for(int j=0;j<p;j++) {
				if(table[j]<=time&&table[j]>pretime) {
					qu.add(table[j]);
				}
			}
			int ct=0;
			while(ct<m) {
				if(qu.peek()!=null&&qu.peek()<=time) {
					kakaotime[i]=Math.max(qu.poll(), kakaotime[i]);
					ct++;
				}
				else {
					break;
				}
			}
			kakao[i]=ct;
			i++;
		}
//		for(int j=0;j<n;j++) {
//			System.out.println("kakao["+j+"] : "+kakao[j]+", time : "+kakaotime[j]);
//		}
		int contime = kakaotime[n-1]-1;
		if(kakao[n-1]<m) {
			contime = bus[n-1];
		}
		String conh="", conm="";
		if(contime/60<10) {
			conh = "0"+((Integer)(contime/60)).toString();
		}
		else conh=((Integer)(contime/60)).toString();
		if(contime%60<10) {
			conm = "0"+((Integer)(contime%60)).toString();
		}
		else conm=((Integer)(contime%60)).toString();
		answer = conh+":"+conm;
		return answer;
	}
	static int stringtoint(String time) {
		String[] t = time.split(":");
		return Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
	}
}
