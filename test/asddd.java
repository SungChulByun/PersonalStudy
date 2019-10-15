package test;
import java.util.*;

public class asddd {
	static int ct, map[][];
	static int[] dx = new int[] {0, -1, 0, 1}, dy = new int[] {-1, 0, 1, 0};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	Queue<int[]> qu = new LinkedList<>();
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	int sx = sc.nextInt();
    	int sy = sc.nextInt();
    	int dir = sc.nextInt();
    	ct=0;
    	int[][] map = new int[n][m];
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			map[i][j]=sc.nextInt();
    		}
    	}
    	qu.add(new int[] {sx, sy, dir});
    	while(!qu.isEmpty()) {
    		int[] tp = qu.poll();
    		int cx = tp[0];
    		int cy = tp[1];
    		int cd = tp[2];
    		int around=0;
    		if(map[cx][cy]==0) {
        		ct++;
        		map[cx][cy]=-ct;
        	}
    		for(int i=0;i<4;i++) {
    			int nx = cx+dx[(cd+4-i)%4];
    			int ny = cy+dy[(cd+4-i)%4];
    			if(map[nx][ny]==0) {
    				qu.add(new int[] {nx, ny, (cd+3-i)%4});
    				i=4;
    			}
    			else {
    				around++;
    			}
    		}
    		if(around==4) {
    			int nx = cx+dx[(cd+3)%4];
    			int ny = cy+dy[(cd+3)%4];
    			if(map[nx][ny]<0) {
    				qu.add(new int[] {nx, ny, cd});
    			}
    			else {
    				qu.clear();
    				break;
    			}
    		}
    	}
//    	printmap(map);
    	System.out.println(ct);
    }
    static void printmap(int[][] x) {
    	for(int i=0;i<x.length;i++) {
    		for(int j=0;j<x[0].length;j++) {
    			String stp = "";
    			String etp = "";
    			if(x[i][j]>=0) {
    				stp=" ";
    				etp=" ";
    			}
    			else if(x[i][j]>=-9) etp=" ";
    			System.out.print(stp+x[i][j]+" "+etp);
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}