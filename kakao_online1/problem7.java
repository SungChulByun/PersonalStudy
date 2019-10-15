package kakao_online1;
import java.util.*;
public class problem7 {
	public static void main(String args[]) {
		int[][] test = new int[][] {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
		System.out.println(solution(test));
	}
	static int n;
	static int dx[] = new int[] {0, 0, 1, -1};
	static int dy[] = new int[] {1, -1, 0, 0};
	
	public static int solution(int[][] board) {
        int answer = 0;
        HashSet<String> visit = new HashSet<>();
        n = board.length;
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[] {0,0,0,1,0});
        while(!qu.isEmpty()) {
        	int[] tp = qu.poll();
        	int x1 = tp[0];
        	int y1 = tp[1];
        	int x2 = tp[2];
        	int y2 = tp[3];
        	int time = tp[4];
        	visit.add(loc(x1, y1, x2, y2));
//        	for(int i=0;i<tp.length;i++) {
//        		System.out.print(tp[i]+" ");
//        	}
//        	System.out.println();
        	if(isfin(x1, y1, x2, y2)) {
        		answer=time;
        		qu.clear();
        		break;
        	}
        	for(int i=0;i<4;i++) {
        		int nx1 = x1+dx[i];
        		int ny1 = y1+dy[i];
        		int nx2 = x2+dx[i];
        		int ny2 = y2+dy[i];
        		if(nx1<0||nx1>=n||nx2<0||nx2>=n||ny1<0||ny1>=n||ny2<0||ny2>=n) continue;
        		if(board[nx1][ny1]==0&&board[nx2][ny2]==0) {
        			if(visit.contains(loc(nx1, ny1, nx2, ny2))) continue;
        			qu.add(new int[] {nx1, ny1, nx2, ny2, time+1});
        			visit.add(loc(nx1, ny1, nx2, ny2));
        		}
        	}
        	if(x1==x2) { // hor
        		if(x1>0) {
        			if(board[x1-1][y1+1]==0&&board[x1-1][y1]==0) {
        				int[] tp1 = rothor(x1, y1, x2, y2, 1, -1);
        				int[] tp2 = rothor(x1, y1, x2, y2, 2, 1);
        				if(!visit.contains(loc(tp1[0], tp1[1], tp1[2], tp1[3]))) {
        					qu.add(new int[] {tp1[0], tp1[1], tp1[2], tp1[3], time+1});
        					visit.add(loc(tp1[0], tp1[1], tp1[2], tp1[3]));
        				}
        				if(!visit.contains(loc(tp2[0], tp2[1], tp2[2], tp2[3]))) {
        					qu.add(new int[] {tp2[0], tp2[1], tp2[2], tp2[3], time+1});
        					visit.add(loc(tp2[0], tp2[1], tp2[2], tp2[3]));
        				}
        			}
        		}
        		if(x1<n-1) {
        			if(board[x1+1][y1+1]==0&&board[x1+1][y1]==0) {
        				int[] tp1 = rothor(x1, y1, x2, y2, 1, 1);
        				int[] tp2 = rothor(x1, y1, x2, y2, 2, -1);
        				if(!visit.contains(loc(tp1[0], tp1[1], tp1[2], tp1[3]))) {
        					qu.add(new int[] {tp1[0], tp1[1], tp1[2], tp1[3], time+1});
        					visit.add(loc(tp1[0], tp1[1], tp1[2], tp1[3]));
        				}
        				if(!visit.contains(loc(tp2[0], tp2[1], tp2[2], tp2[3]))) {
        					qu.add(new int[] {tp2[0], tp2[1], tp2[2], tp2[3], time+1});
        					visit.add(loc(tp2[0], tp2[1], tp2[2], tp2[3]));
        				}
        			}
        		}
        	}
        	if(y1==y2) {//ver
        		if(y1>0) {
        			if(board[x1+1][y1-1]==0&&board[x1][y1-1]==0) {
        				int[] tp1 = rotver(x1, y1, x2, y2, 1, 1);
        				int[] tp2 = rotver(x1, y1, x2, y2, 2, -1);
        				if(!visit.contains(loc(tp1[0], tp1[1], tp1[2], tp1[3]))) {
        					qu.add(new int[] {tp1[0], tp1[1], tp1[2], tp1[3], time+1});
        					visit.add(loc(tp1[0], tp1[1], tp1[2], tp1[3]));
        				}
        				if(!visit.contains(loc(tp2[0], tp2[1], tp2[2], tp2[3]))) {
        					qu.add(new int[] {tp2[0], tp2[1], tp2[2], tp2[3], time+1});
        					visit.add(loc(tp2[0], tp2[1], tp2[2], tp2[3]));
        				}
        			}
        		}
        		if(y1<n-1) {
        			if(board[x1+1][y1+1]==0&&board[x1][y1+1]==0) {
        				int[] tp1 = rotver(x1, y1, x2, y2, 1, -1);
        				int[] tp2 = rotver(x1, y1, x2, y2, 2, 1);
        				if(!visit.contains(loc(tp1[0], tp1[1], tp1[2], tp1[3]))) {
        					qu.add(new int[] {tp1[0], tp1[1], tp1[2], tp1[3], time+1});
        					visit.add(loc(tp1[0], tp1[1], tp1[2], tp1[3]));
        				}
        				if(!visit.contains(loc(tp2[0], tp2[1], tp2[2], tp2[3]))) {
        					qu.add(new int[] {tp2[0], tp2[1], tp2[2], tp2[3], time+1});
        					visit.add(loc(tp2[0], tp2[1], tp2[2], tp2[3]));
        				}
        			}
        		}
        	}
        }
        return answer;
    }
	static boolean isfin(int x1, int y1, int x2, int y2) {
		if((x1==n-1&&y1==n-1)||(x2==n-1&&y2==n-1)) return true;
		else return false;
	}
	static int[] rothor(int x1, int y1, int x2, int y2, int standard,int clockwise) {
		if(standard==1) { // y1<y2 가정
			if(clockwise==1) {
				return (new int[] {x1, y1, x1+1, y1});
			}
			else {
				return (new int[] {x1-1, y1, x1, y1});
			}
		}
		else {
			if(clockwise==1) {
				return (new int[] {x2-1, y2, x2, y2});
			}
			else {
				return (new int[] {x2, y2, x2+1, y2});
			}
		}
	}
	static int[] rotver(int x1, int y1, int x2, int y2, int standard,int clockwise) {
		if(standard==1) { // x1<x2 가정
			if(clockwise==1) {
				return (new int[] {x1, y1-1, x1, y1});
			}
			else {
				return (new int[] {x1, y1, x1, y1+1});
			}
		}
		else {
			if(clockwise==1) {
				return (new int[] {x2, y2, x2, y2+1});
			}
			else {
				return (new int[] {x2, y2-1, x2, y2});
			}
		}
	}
	static String loc(int x1, int y1, int x2, int y2) {
		String tp = "";
		return tp+x1+","+y1+","+x2+","+y2+",";
	}
}