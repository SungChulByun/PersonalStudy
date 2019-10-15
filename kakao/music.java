package kakao;
import java.util.Arrays;

public class music {
	public static void main(String args[]) {
		String m1 = "ABCDEFG";
		String[] t1 = new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		String result1 = solution(m1, t1);
		System.out.println(result1);
		
		String m2 = "CC#BCC#BCC#BCC#B";
		String[] t2 = new String[] {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		String result2 = solution(m2, t2);
		System.out.println(result2);
		
		String m3 = "ABCDEF";
		String[] t3 = new String[] {"12:00,12:05,HELLO,DEFABC", "13:00,13:06,WORLD,ABCDEF"};
		String result3 = solution(m3, t3);
		System.out.println(result3);
		
		for(int i=0;i<m2.length();i++) {
			if(m2.charAt(i)=='#') m2 = change(m2, i);
		}
		System.out.println(m2);
	}
	public static String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		String chm = m;
		for(int i=0;i<chm.length();i++) {
			if(chm.charAt(i)=='#') chm=change(chm, i);
		}
		int len = musicinfos.length;
		radiomusic[] data = new radiomusic[len];
		for(int i=0;i<len;i++) {
			String[] tp = musicinfos[i].split(",");
			int stime = strToint(tp[0]);
			int etime = strToint(tp[1]);
			if(etime<stime&&etime==0) etime=2400;
			int term = etime-stime;
			String name = tp[2];
			String melody = tp[3];
			for(int j=0;j<melody.length();j++) {
				if(melody.charAt(j)=='#') melody=change(melody, j);
			}

			radiomusic temp = new radiomusic(stime, term, name, melody);
			temp.setMelody();
			data[i]=temp;
		}
		Arrays.sort(data);
		for(int i=0;i<len;i++) {
//			System.out.println("Name : "+data[i].getName()+", melody : "+data[i].getMelody());
			if(data[i].getMelody().indexOf(chm)>=0) {
				return data[i].getName();
			}
		}
		return answer;
	}
	public static String change(String mel, int x) {
		char tp = Character.toLowerCase(mel.charAt(x-1));
		String head = mel.substring(0, x-1);
		String tail = mel.substring(x+1);
		return head+tp+tail;
	}
	public static int strToint(String time) {
		String[] tp = time.split(":");
		return Integer.parseInt(tp[0])*60+Integer.parseInt(tp[1]);

	}
}
class radiomusic implements Comparable<radiomusic>{
	private int sttime;
	private int term;
	private String name;
	private String melody;
	private String fullmelody;
	public radiomusic(int time, int term, String name, String melody) {
		this.sttime=time;
		this.term=term;
		this.name=name;
		this.melody=melody;
		this.fullmelody="";
	}
	public void setMelody() {
		int replay = this.term/this.melody.length();
		int remain = this.term%this.melody.length();
		for(int i=0;i<replay;i++) {
			this.fullmelody+=melody;
		}
		this.fullmelody+=this.melody.substring(0, remain);
	}
	public String getMelody() {
		return this.fullmelody;
	}
	public String getName() {
		return this.name;
	}
	public int getTime() {
		return this.sttime;
	}
	public int getTerm() {
		return this.term;
	}
	public int compareTo(radiomusic rm) {
		if(rm.getTerm()==this.term) {
			return this.getTime()-rm.getTime();
		}
		else {
			return rm.getTerm()-this.term;
		}
	}
}