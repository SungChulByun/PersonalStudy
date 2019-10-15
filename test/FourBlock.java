package test;
import java.util.*;


public class FourBlock {
	
    static char[][] map;
    static int M, N, info[];
    static boolean fin;
    static Queue<Integer[]> qu = new LinkedList<Integer[]>();
    public static void main(String args[]) {
    	int a = 10;
    	int b = 2; 
    	int c = a <= b ?10: -10;
    	System.out.println(c);
	}
    static int solution(int m, int n, String[] board) {
      int answer = 0;
      M = m;
      N = n;

      map = new char[M+1][N];
      info = new int[N];
      fin = false;
      for(int i=1;i<M+1;i++){
          for(int j=0;j<N;j++){
              map[i][j]=board[i-1].charAt(j);
          }
      }

      for(int j=0;j<N;j++){
          map[0][j]='0';
      }
      fin = false;
      while(!fin){
          int data[] = new int[N];
          fin=true;
          for(int i=1;i<M;i++){
              for(int j=0;j<N-1;j++){
                  if(isBox(i, j)){
                	  data[j]++;
                	  data[j+1]++;
                      fin = false;
                      qu.add(new Integer[] {i, j});
                  }
              }
          }
          while(!qu.isEmpty()){
              Integer[] x = qu.poll();
              change(x[0], x[1]);
          }

          for(int i=0;i<N;i++) {
        	  for(int j=0;j<data[i];j++) {
        		  down(i);
        		  down(i);
        	  }
          }
          printmap();
      }
    
      for(int i=0;i<M+1;i++){
          for(int j=0;j<N;j++){
              if(map[i][j]!='0') answer++;
          }
      }
      return ((M*N)-answer);
  }
    static boolean isBox(int x, int y){
        char a = map[x][y];
        if(a=='0') return false;
        if(map[x+1][y]!=a) return false;
        if(map[x+1][y+1]!=a) return false;
        if(map[x][y+1]!=a) return false;
        return true;
    }
    static void change(int x, int y){
        map[x][y]='0';
        map[x+1][y+1]='0';
        map[x+1][y]='0';
        map[x][y+1]='0';
    }
    static void down(int y){
        int loc = M;
        while(loc>=1){
            if(map[loc][y]=='0'){
                for(int i=loc;i>=1;i--){
                    map[i][y]=map[i-1][y];
                }
            }
            loc--;
        }
    }
    static void printmap() {
    	for(int i=0;i<M+1;i++) {
    		for(int j=0;j<N;j++) {
    			System.out.print(map[i][j]+" ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}