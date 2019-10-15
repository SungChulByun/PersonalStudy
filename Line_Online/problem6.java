package Line_Online;

import java.util.*;
public class problem6 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String sortloc = sc.next();
		
		int type=0;
		if(sortloc.charAt(0)=='T') type=1;
		else if(sortloc.charAt(0)=='M') type=2;
		else if(sortloc.charAt(0)=='B') type=3;
		
		int data[][] = new int[n][2];
		int max = 0;
		for(int i=0;i<n;i++) {
			data[i][0]=sc.nextInt();
			data[i][1]=sc.nextInt();
			max = Math.max(max, data[i][0]);
		}
		char[][] answer;
		String numstring =Integer.toString(data[0][1]); 
		int len = numstring.length();
		answer=settype(number(numstring.charAt(0)-'0', data[0][0]), max, type);
//		printmap(answer);
		for(int i=1;i<len;i++) {
			answer=combine(answer, settype(number(numstring.charAt(i)-'0', data[0][0]), max, type));
		}
		for(int j=1;j<n;j++) {
			char[][] tp;
			String tpnumstring =Integer.toString(data[j][1]); 
			int tplen = tpnumstring.length();
			tp=settype(number(tpnumstring.charAt(0)-'0', data[j][0]), max, type);
			for(int i=1;i<tplen;i++) {
				tp=combine(tp, settype(number(tpnumstring.charAt(i)-'0', data[j][0]), max, type));
			}
			answer=combine(answer, tp);
		}
		printmap(rotate(answer));
		
	}
	static char[][] rotate(char[][] x){
		int xx=x.length;
		int yy=x[0].length;
		char[][] re = new char[yy][xx];
		for(int i=0;i<yy;i++) {
			for(int j=0;j<xx;j++) {
				re[yy-1-i][j]=x[j][i];
			}
		}
		return re;
	}
	static char[][] settype(char[][] x, int maxsize, int type){
		if(x.length==maxsize) return x;
		else {
			int xlen=x.length;
			int mlen = 2*maxsize-1;
			char[][] re = new char[xlen][mlen];
			for(int i=0;i<xlen;i++) {
				for(int j=0;j<mlen;j++) {
					re[i][j]='.';
				}
			}
			if(type==1) { //Top
				for(int i=0;i<xlen;i++) {
					for(int j=0;j<2*xlen-1;j++) {
						re[i][j+2*(maxsize-xlen)]=x[i][j];
					}
				}
			}
			else if(type==2) { // Mid
				for(int i=0;i<xlen;i++) {
					for(int j=0;j<2*xlen-1;j++) {
						re[i][j+(maxsize-xlen)]=x[i][j];
					}
				}
			}
			else {
				for(int i=0;i<xlen;i++) {
					for(int j=0;j<2*xlen-1;j++) {
						re[i][j]=x[i][j];
					}
				}
			}
			
			return re;
		}
	}
	static char[][] combine(char[][] x, char[][] y){
		int xlen = x.length;
		int ylen = y.length;
		char[][] re = new char[xlen+ylen+1][x[0].length];
		for(int i=0;i<re.length;i++) {
			for(int j=0;j<re[0].length;j++) {
				re[i][j]='.';
			}
		}
		for(int i=0;i<x[0].length;i++) {
			re[xlen][i]=' ';
		}
		for(int i=0;i<xlen;i++) {
			for(int j=0;j<x[0].length;j++) {
				re[i][j]=x[i][j];
			}
		}
		for(int i=0;i<ylen;i++) {
			for(int j=0;j<y[0].length;j++) {
				re[xlen+1+i][j]=y[i][j];
			}
		}
		
		return re;
	}
	static char[][] number(int x, int s){
		char[][] re = new char[s][2*s-1];
		for(int i=0;i<s;i++) {
			for(int j=0;j<2*s-1;j++) {
				re[i][j]='.';
			}
		}
		if(x==0) {
			for(int i=0;i<s;i++) {
				re[i][0]='#';
				re[i][2*s-2]='#';
			}
			for(int i=1;i<2*s-1;i++) {
				re[0][i]='#';
				re[s-1][i]='#';
			}
		}
		else if(x==1) {
			for(int i=0;i<2*s-1;i++) {
				re[s-1][i]='#';
			}
		}
		else if(x==2) {
			for(int i=0;i<s;i++) {
				re[i][0]='#';
				re[i][s-1]='#';
				re[i][2*s-2]='#';
			}
			for(int i=0;i<s;i++) {
				re[0][i]='#';
				re[s-1][s-1+i]='#';
			}
		}
		else if(x==3) {
			for(int i=0;i<s;i++) {
				re[i][0]='#';
				re[i][s-1]='#';
				re[i][2*s-2]='#';
			}
			for(int i=0;i<2*s-1;i++) {
				re[s-1][i]='#';
			}
		}
		else if(x==4) {
			for(int i=0;i<s;i++) {
				re[i][s-1]='#';
			}
			for(int i=0;i<2*s-1;i++) {
				re[s-1][i]='#';
			}
			for(int i=0;i<s;i++) {
				re[0][s-1+i]='#';
			}
		}
		else if(x==5) {
			for(int i=0;i<s;i++) {
				re[i][0]='#';
				re[i][s-1]='#';
				re[i][2*s-2]='#';
			}
			for(int i=0;i<s;i++) {
				re[0][s-1+i]='#';
				re[s-1][i]='#';
			}
		}
		else if(x==6) {
			for(int i=0;i<s;i++) {
				re[i][0]='#';
				re[i][s-1]='#';
			}
			for(int i=0;i<2*s-1;i++) {
				re[0][i]='#';
			}
			for(int i=0;i<s;i++) {
				re[s-1][i]='#';
			}
		}
		else if(x==7) {
			for(int i=0;i<2*s-1;i++) {
				re[s-1][i]='#';
			}
			for(int i=0;i<s;i++) {
				re[i][2*s-2]='#';
			}
		}
		else if(x==8) {
			for(int i=0;i<s;i++) {
				re[i][0]='#';
				re[i][s-1]='#';
				re[i][2*s-2]='#';
			}
			for(int i=0;i<2*s-1;i++) {
				re[s-1][i]='#';
				re[0][i]='#';
			}
		}
		else {
			for(int i=0;i<s;i++) {
				re[i][s-1]='#';
				re[i][2*s-2]='#';
			}
			for(int i=0;i<2*s-1;i++) {
				re[s-1][i]='#';
			}
			for(int i=0;i<s;i++) {
				re[0][s-1+i]='#';
			}
		}
		return re;
	}
	static void printmap(char[][] map) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}