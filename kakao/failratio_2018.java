package kakao;

import java.util.Arrays;
import java.util.Collections;

public class failratio_2018 {
	public static void main(String args[]) {
		int[] test = new int[] {2, 1, 2, 6, 2, 4, 3, 3};
		int[] result = solution(5, test);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}
	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int len = stages.length;
        int[] fail = new int[N+1];
        int[] pass = new int[N+1];
        Node1[] list = new Node1[N];
        double[] ratio = new double[N+1];
        for(int i=0;i<len;i++) {
        	if(stages[i]!=N+1) {
            	fail[stages[i]]++;        		
        	}
        	for(int j=stages[i]-1;j>=1;j--) {
        		pass[j]++;
        	}
        }
        for(int i=1;i<=N;i++) {
        	ratio[i]=((double) fail[i])/((double) fail[i]+pass[i]);
        }
        for(int i=0;i<N;i++) {
        	Node1 nd = new Node1(ratio[i+1], i+1);
        	list[i]=nd;
        }
        Arrays.sort(list, Collections.reverseOrder());
        for(int i=0;i<N;i++) {
        	answer[i]=list[i].getNo();
        }
        return answer;
    }
}
class Node1 implements Comparable<Node1>{
	private double ratio;
	private int no;
	public void setRatio(double rat) {
		this.ratio=rat;
	}
	public double getRatio() {
		return this.ratio;
	}
	public void setNo(int n) {
		this.no = n;
	}
	public int getNo() {
		return this.no;
	}
	
	public Node1(double rat, int n){
		this.ratio = rat;
		this.no = n;
	}
	@Override
	public int compareTo(Node1 nd) {
		if(nd.getRatio()==this.getRatio()) {
			return -(this.getNo()-nd.getNo());
		}
		else {
			return compare(nd);
		}
	}
	public int compare(Node1 nd) {
		double tp = this.getRatio()-nd.getRatio();
		if(tp>0) {
			return 1;
		}
		else if(tp<0) {
			return -1;
		}
		else {
			return 0;
		}
	}
}