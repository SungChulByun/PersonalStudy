package kakao;

import java.util.*;
public class sorting {
	public static void main(String args[]) {
		String[] test = {"mg123456.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] result = solution(test);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}
	public static String[] solution(String[] files) {
		int n = files.length;
		filename[] data = new filename[n];
		String[] answer =new String[n];
		for(int i=0;i<n;i++) {
			String tp = files[i];
			int startNum = 0;

			for(int j=0;j<tp.length();j++) {
				if(isNum(tp.charAt(j))) {
					startNum=j;
					j+=tp.length();
				}
			}
			int end = Math.min(tp.length(), startNum+5);
			int endNum=end;
			for(int j=startNum;j<end;j++) {
				if(!isNum(tp.charAt(j))) {
					endNum=j;
					j+=5;
				}
			}
			String head = tp.substring(0, startNum).toLowerCase();
			int num = Integer.parseInt(tp.substring(startNum, endNum));
			filename nfile = new filename(tp, i, head, num);
			data[i]=nfile;
		}
		Arrays.sort(data);
		for(int i=0;i<n;i++) {
			answer[i]=data[i].getName();
		}
		
		return answer;
	}
	public static boolean isAlpha(char x) {
		if ((x>='a'&&x<='z')&&(x>='A'&&x<='Z')){
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isNum(char x) {
		if(x>='0'&&x<='9') return true;
		else return false;
	}

}

class filename implements Comparable<filename>{
	private String name;
	private int no;
	private String head;
	private int num;
	public String getName() {
		return this.name;
	}
	public filename(String name, int no, String head, int num) {
		this.name=name;
		this.no=no;
		this.head=head;
		this.num=num;
	}
	@Override
	public int compareTo(filename fn) {
		if(this.head.compareTo(fn.head)==0) {
			return this.num-fn.num;
		}
		else {
			return this.head.compareTo(fn.head);
		}
	}
}