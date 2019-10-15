package kakao;

import java.util.*;
public class Kakao2018_findingroot{
    public static void main(String[] args) {
    	int[][] test = new int[][] {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
    	int[][] result = solution(test);
    	for(int i=0;i<test.length;i++) {
    		System.out.print(result[0][i]+" ");
    	}
    	System.out.println();
    	for(int i=0;i<test.length;i++) {
    		System.out.print(result[1][i]+" ");
    	}
    }
    static Queue<Integer> pre = new LinkedList<Integer>();
    static Queue<Integer> post = new LinkedList<Integer>();
    public static int[][] solution(int[][] nodeinfo) {

        int len = nodeinfo.length;
        int[][] answer = new int[2][len];
        Node[] list = new Node[len];
        Node root;
        for(int i=0;i<len;i++) {
        	Node nd = new Node(null, null, nodeinfo[i][0], nodeinfo[i][1], i);
        	list[i]=nd;
        }
        Arrays.sort(list, Collections.reverseOrder());
        root = list[0];
        for(int i=1;i<len;i++) {
        	root.add(list[i]);
        }
        preorder(root);
        postorder(root);
        for(int i=0;i<len;i++) {
        	answer[0][i]=pre.poll();
        	answer[1][i]=post.poll();
        }
        return answer;
    }
    static void preorder(Node nd) {
    	if(nd==null) {
    		return;
    	}
    	pre.add(nd.getNo());
    	preorder(nd.getLeft());
    	preorder(nd.getRight());
    }
    static void postorder(Node nd) {
    	if(nd==null) {
    		return;
    	}
    	postorder(nd.getLeft());
    	postorder(nd.getRight());
    	post.add(nd.getNo());
    }
}

class Node implements Comparable<Node>{
	private Node left;
	private Node right;
	private int xValue;
	private int yValue;
	private int no;
	public Node(Node left, Node right, int xVal, int yVal, int no) {
		this.left = left;
		this.right = right;
		this.xValue=xVal;
		this.yValue=yVal;
		this.no = no+1;
	}
	public void add(Node nd) {
		if(nd.getxValue()<this.getxValue()) {
			if(this.getLeft()==null) {
				this.setLeft(nd);
			}
			else {
				this.getLeft().add(nd);
			}
		}
		else {
			if(this.getRight()==null) {
				this.setRight(nd);
			}
			else {
				this.getRight().add(nd);
			}
		}
	}
	public void setLeft(Node nd) {
		this.left = nd;
	}
	public Node getLeft() {
		return this.left;
	}
	public void setRight(Node nd) {
		this.right = nd;
	}
	public Node getRight() {
		return this.right;
	}
	public int getxValue() {
		return this.xValue;
	}
	public int getyValue() {
		return this.yValue;
	}
	public int getNo() {
		return this.no;
	}
	
	@Override
	public int compareTo(Node compareNode) {
		int re = this.yValue-compareNode.yValue; 
		if(re==0) {
			return this.xValue-compareNode.xValue;
		}
		else {
			return re;
		}
	}
}