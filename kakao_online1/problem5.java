package kakao_online1;

import java.util.*;
public class problem5 {
	public static void main(String args[]) {
		int[][] bf1 = new int[][] {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		int[][] result1 = solution(5, bf1);
		int[][] bf2 = new int[][] {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		int[][] result2 = solution(5, bf2);
		for(int i=0;i<result2.length;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(result2[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int nn;
	static HashSet<String> pil = new HashSet<>();
	static HashSet<String> floor = new HashSet<>();
	public static int[][] solution(int n, int[][] build_frame) {
        pil.clear();
        floor.clear();
        nn=n;
		for(int i=0;i<build_frame.length;i++) {
        	operation(build_frame[i][0], build_frame[i][1], build_frame[i][2], build_frame[i][3]);
        }
        int[][] answer = new int[pil.size()+floor.size()][3];
        structure[] temp = new structure[pil.size()+floor.size()];
        int ct=0;
        for(String x:pil) {
        	String[] tp = x.split(",");
        	structure stp = new structure(Integer.parseInt(tp[0]), Integer.parseInt(tp[1]), 0);
        	temp[ct]=stp;
        	ct++;
        }
        for(String x:floor) {
        	String[] tp = x.split(",");
        	structure stp = new structure(Integer.parseInt(tp[0]), Integer.parseInt(tp[1]), 1);
        	temp[ct]=stp;
        	ct++;
        }
        Arrays.sort(temp);
        for(int i=0;i<temp.length;i++) {
        	answer[i]=new int[] {temp[i].x, temp[i].y, temp[i].type};
        }
        return answer;
    }
	static String loctostr(int x, int y) {
		String tp = "";
		return tp+x+","+y;
	}
	static void makepil(int x, int y) {
		pil.add(loctostr(x, y));
	}
	static void makefloor(int x, int y) {
		floor.add(loctostr(x, y));
	}
	static void removepil(int x, int y) {
		pil.remove(loctostr(x, y));
	}
	static void removefloor(int x, int y) {
		floor.remove(loctostr(x, y));
	}
	static int rightend(int x) {
		return Math.min(x, nn);
	}
	static int leftend(int x) {
		return Math.max(x, 0);
	}
	static void operation(int x, int y, int type, int status) {
		if(type==0) { //기둥 : pil
			if(status==1) { // 설치
				if(y==0) makepil(x, y);
				else {
					if(pil.contains(loctostr(x, leftend(y-1)))) makepil(x, y);
					else {
						String left = loctostr(leftend(x-1), y);
						String right = loctostr(x, y);
						int ct=0;
						if(floor.contains(left)) ct++;
						if(floor.contains(right)) ct++;
						if(ct==1) makepil(x, y);
					}
				}
			}
			else { //제거
				String left = loctostr(leftend(x-1), y+1);
				String right = loctostr(x, y+1);
				if(floor.contains(left)&&floor.contains(right)) removepil(x, y);
				else if(!floor.contains(left)&&!floor.contains(right)) removepil(x, y);
				else if(floor.contains(left)) {
					if(pil.contains(loctostr(leftend(x-1),y))) removepil(x, y);
				}
				else if(floor.contains(right)) {
					if(pil.contains(loctostr(x+1,y))) removepil(x, y);
				}
			}
		}
		else { // 보 : floor
			if(status==1) { // 설치
				if(pil.contains(loctostr(x, leftend(y-1)))||pil.contains(loctostr(x+1, leftend(y-1)))) {
					makefloor(x, y);
				}
				else {
					if(floor.contains(loctostr(leftend(x-1),y))&&floor.contains(loctostr(x+1,y))) {
						makefloor(x, y);
					}
				}
			}
			else { // 제거
				if(pil.contains(loctostr(x, y+1))) {
					if(pil.contains(loctostr(x, y))) removefloor(x, y);
				}
				else if(pil.contains(loctostr(x+1, y+1))) {
					if(pil.contains(loctostr(x+1, y))) removefloor(x, y);
				}
				else {
					String left = loctostr(leftend(x-1), y);
					String right = loctostr(x+1, y);
					boolean leftok = pil.contains(loctostr(x-1, y-1))||pil.contains(loctostr(x, y-1));
					boolean rightok = pil.contains(loctostr(x, y-1))||pil.contains(loctostr(x+1, y-1));
					if(floor.contains(left)&&floor.contains(right)) {
						if(leftok&&rightok) {
							removefloor(x, y);
						}
					}
					else if(floor.contains(left)) {
						if(leftok) removefloor(x, y);
					}
					else if(floor.contains(right)) {
						if(rightok) removefloor(x, y);
					}
					else {
						removefloor(x, y);
					}
				}
			}
		}
	}
}
class structure implements Comparable<structure>{
	int x, y, type;
	public structure(int x, int y, int t) {
		this.x=x;
		this.y=y;
		this.type=t;
	}
	@Override
	public int compareTo(structure st) {
		if(this.x==st.x) {
			if(this.y==st.y) {
				return this.type-st.type;
			}
			else {
				return this.y-st.y;
			}
		}
		else {
			return this.x-st.x;
		}
	}
}
