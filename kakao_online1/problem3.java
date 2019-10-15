package kakao_online1;

public class problem3 {
	public static void main(String args[]) {
		int[][] key =new int[][] {{1,1,1},
								  {1,0,1},
								  {1,1,1}};
		int[][] lock = new int[][] {{0,0,0},
									{0,1,0},
									{0,0,0}};
		System.out.println(solution(key, lock));
	}
	static int n, m, large[][];
	public static boolean solution(int[][] key, int[][] lock) {
		m = key.length;
		n = lock.length;
		
		int[][] key1 = rot1(key);
		int[][] key2 = rot2(key);
		int[][] key3 = rot3(key);
		mapclear(lock);
		if(isfin()) return true;
		for(int i=0;i<m+n-1;i++) {
			for(int j=0;j<m+n-1;j++) {
				//key
				mapclear(lock);
				for(int xx=0;xx<m;xx++) {
					for(int yy=0;yy<m;yy++) {
						large[i+xx][j+yy]+=key[xx][yy];
					}
				}
				if(isfin()) return true;
				//key1
				mapclear(lock);
				for(int xx=0;xx<m;xx++) {
					for(int yy=0;yy<m;yy++) {
						large[i+xx][j+yy]+=key1[xx][yy];
					}
				}
				if(isfin()) return true;
				//key2
				mapclear(lock);
				for(int xx=0;xx<m;xx++) {
					for(int yy=0;yy<m;yy++) {
						large[i+xx][j+yy]+=key2[xx][yy];
					}
				}
				if(isfin()) return true;
				//key3
				mapclear(lock);
				for(int xx=0;xx<m;xx++) {
					for(int yy=0;yy<m;yy++) {
						large[i+xx][j+yy]+=key3[xx][yy];
					}
				}
				if(isfin()) return true;
			}
		}
		return false;
	}
	static void printmap(int[][] map) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void mapclear(int[][] map){
		int len = n+2*m-2;
		large = new int[len][len];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				large[m-1+i][m-1+j]=map[i][j];
			}
		}
	}
	static boolean isfin() {
		for(int i=m-1;i<n+m-1;i++) {
			for(int j=m-1;j<n+m-1;j++) {
				if(large[i][j]!=1) return false;
			}
		}
		return true;
	}
	static int[][] rot1(int[][] map){
		int len = map.length;
		int[][] tp = new int[len][len];
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				tp[j][len-i-1]=map[i][j];
			}
		}
		return tp;
	}
	static int[][] rot2(int[][] map){
		int len = map.length;
		int[][] tp = new int[len][len];
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				tp[len-i-1][len-j-1]=map[i][j];
			}
		}
		return tp;
	}
	static int[][] rot3(int[][] map){
		int len = map.length;
		int[][] tp = new int[len][len];
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				tp[len-j-1][i]=map[i][j];
			}
		}
		return tp;
	}
}
