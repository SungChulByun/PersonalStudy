package winter_intern_2019;

import java.util.*;

public class problem1 {
	static ArrayList<Integer> movedList;
	public static void main(String args[]) {
		int sample = solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4});
		System.out.println(sample);
	}
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        movedList = new ArrayList<>();
        
    	
        for(int i=0;i<moves.length;i++) {
        	int picked = pick(board, moves[i]);
        	if(picked>0) {
        		answer += moveToRight(picked);
        	}
        }
        
        return answer;
    }
	
	public static int pick(int[][] board, int y) {
		int picked = 0;
		int n = board.length;
		for(int i=0;i<n;i++) {
			if(board[i][y-1]>0) {
				picked = board[i][y-1];
				board[i][y-1] = 0;
				return picked;
			}
		}
		
		return picked;
	}
	
	public static int moveToRight(int picked) {
		if(movedList.size()==0) {
			movedList.add(picked);
			return 0;
		}
		else {
			if(movedList.get(movedList.size()-1) == picked) {
				movedList.remove(movedList.size()-1);
				return 2;
			}
			else {
				movedList.add(picked);
				return 0;
			}
		}
	}
	
	
	public static void printMap(int[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printMoved() {
		System.out.print("movedList : ");
		for(int i=0;i<movedList.size();i++) {
			System.out.print(movedList.get(i) + " ");
		}
		System.out.println();
		System.out.println();
	}
	
}
