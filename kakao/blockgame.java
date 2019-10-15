package kakao;

import java.util.*;
public class blockgame {
	public static void main(String args[]) {
		int[][] testboard = new int[][] {{0,0,0,0},
										 {0,0,2,2},
										 {0,0,1,2},
										 {1,1,1,2}};
		int result = solution(testboard);
		System.out.println(result);
	}
	public static int solution(int [][] board) {
		HashMap<Integer, String> line = new HashMap<>();
		HashSet<Integer> avail = new HashSet<>();
		HashSet<Integer> unavail = new HashSet<>();
		int map[][];
		map = board.clone();
		int n = map.length;
		int max=0;
		for(int i=0;i<n;i++) {
			int[] temp = new int[201];
			for(int j=0;j<n;j++) {
				max = Math.max(max, map[i][j]);
				if(map[i][j]>0) temp[map[i][j]]++;
			}
			for(int j=1;j<=200;j++) {
				if(temp[j]>0) {
					if(line.containsKey(j)) {
						line.put(j, line.get(j)+((Integer) temp[j]).toString());
					}
					else {
						line.put(j, ((Integer) temp[j]).toString());
					}
				}
			}
		}
		for(int i=1;i<=max;i++) {
			if(line.containsKey(i)) {
				if(isAvail(line.get(i))) avail.add(i);
				else unavail.add(i);
			}
		}
//		System.out.print("before avail : ");
//		printset(avail);
//		System.out.print("-----unavail : ");
//		printset(unavail);
		boolean operating=true;
		while(operating) {
			operating=false;
			for(int j=0;j<n;j++) {
				boolean black=false;
				for(int i=0;i<n;i++) {
					if(black) {
						if(avail.contains(map[i][j])) {
							if(i<=n-3) {
								if(map[i][j]==map[i+1][j]) {
									if(map[i+2][j]==map[i][j]) i+=2;
									else i+=1;
								}
								else {
									avail.remove(map[i][j]);
									unavail.add(map[i][j]);
									operating=true;
								}
							}
							else if(i==n-2) {
								if(map[i][j]==map[i+1][j]) {
									i++;
								}
								else {
									avail.remove(map[i][j]);
									unavail.add(map[i][j]);
									operating=true;
								}
							}
							else {
								avail.remove(map[i][j]);
								unavail.add(map[i][j]);
								operating=true;
							}
						}
					}
					else {
						if(unavail.contains(map[i][j])) {
//							System.out.println("black (i, j) : "+i+", "+j);
							black=true;
						}
					}
				}
			}
		}
//		System.out.print("-after avail : ");
//		printset(avail);
		
		return avail.size();
	}
	static void printset(HashSet<Integer> set) {
		for(Integer elem:set) {
			System.out.print(elem+" ");
		}
		System.out.println();
	}
	static boolean isAvail(String x) {
		int len = x.length();
		for(int i=0;i<len-1;i++) {
			if(x.charAt(i)>x.charAt(i+1)) return false;
		}
		return true;
	}
}