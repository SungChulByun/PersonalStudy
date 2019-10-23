package SWAcademy;
import java.util.*;
import java.io.*;
public class SWD5_7396_DaughterName {
	static int dx[] = new int[] {0, 1};
	static int dy[] = new int[] {1, 0};
	static int n, m;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String ans[] = new String[t];
		for(int tc=0;tc<t;tc++) {
			String tp[] = br.readLine().split(" ");
			n = Integer.parseInt(tp[0]);
			m = Integer.parseInt(tp[1]);
			char[][] map = new char[n][m];
			for(int i=0;i<n;i++) {
				String line = br.readLine();
				for(int j=0;j<m;j++) {
					map[i][j]=line.charAt(j);
				}
			}
			ans[tc]=func(map);
		}
		for(int i=0;i<t;i++) {
			System.out.println("#"+(i+1)+" "+ans[i]);
		}
	}
	static String func(char[][] map) {
		String re = "";
		Queue<node> qu = new LinkedList<node>();
		Queue<node> storage = new LinkedList<node>();
		qu.add(new node(0, 0, map[0][0]));
		while(re.length()<n+m-1) {
			storage.clear();
			node tptp = qu.peek();
			if(tptp!=null) re+=tptp.ch;
//			System.out.println("len : "+re.length()+", str : "+re);
			char min = 'z'+1;
			while(!qu.isEmpty()) {
				node tp = qu.poll();
				for(int i=0;i<2;i++) {
					int nx=tp.x+dx[i];
					int ny=tp.y+dy[i];
					if(nx>=0&&nx<n&&ny>=0&&ny<m) {
						if(map[nx][ny]<min) {
							storage.clear();
							storage.add(new node(nx, ny, map[nx][ny]));
							min=map[nx][ny];
						}
						else if(map[nx][ny]==min) {
							storage.add(new node(nx, ny, map[nx][ny]));
						}
					}
				}
			}
			while(!storage.isEmpty()) {
				qu.add(storage.poll());
			}
		}
		return re;
		
	}
}

class node implements Comparable<node>{
	int x, y;
	char ch;
	public node(int x, int y, char ch) {
		this.x=x;
		this.y=y;
		this.ch=ch;
	}
	
	public int compareTo(node nd) {
		return this.ch-nd.ch;
	}
}