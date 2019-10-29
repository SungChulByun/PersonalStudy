package SWAcademy;
import java.util.*;
public class SW_mock_cell_5653 {
	static int n, m, map[][], gap = 300,
			dx[] = new int[] {0, 0, 1, -1},
			dy[] = new int[] {1, -1, 0, 0};
	static HashMap<String, Integer> temp = new HashMap<String, Integer>();
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int ans[] = new int[t];
		for(int tc=0;tc<t;tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) map[gap+i][gap+j]=sc.nextInt();
			}
		}
	}
	static void onehour() {
		
	}
}
class cell{
	int x, y, power, remain;
	public cell(int x, int y, int power) {
		this.x=x;
		this.y=y;
		this.power=power;
		remain=this.power;
		
	}
}
