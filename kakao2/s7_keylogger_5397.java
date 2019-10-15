package kakao2;

import java.util.*;
import java.io.*;
public class s7_keylogger_5397 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String data[] = new String[n];
		for(int t=0;t<n;t++) {
			
			String answer="";
			Nodelist list = new Nodelist();
			String input = br.readLine();
			for(int i=0;i<input.length();i++) {
				char tp = input.charAt(i);
				if(tp=='-') {
					list.delete();
				}
				else if(tp=='<') {
					list.left();
				}
				else if(tp=='>') {
					list.right();
				}
				else {
					list.type(tp);
				}
			}
			list.cursor=list.front.tail;
			while(list.cursor.tail!=null) {
//				System.out.println("here ");
				answer+=list.cursor.letter;
				list.cursor=list.cursor.tail;
			}
			answer+=list.cursor.letter;
			data[t]=answer;
		}
		for(int i=0;i<n;i++) {
			System.out.println(data[i]);
		}
	}
	
}
class Nodelist {
	Node front;
	Node cursor;
	public Nodelist() {
		front=new Node(null, null, ' ');
		cursor=null;
	}
	public void delete() {
		if(cursor==null) return;
		if(cursor.head==front) {
			if(cursor.tail!=null) {
				cursor=cursor.tail;
				cursor.head=front;
				front.tail=cursor;
			}
			else {
				cursor=null;
				front.tail=null;
			}
		}
		else {
			if(cursor.tail!=null) {
				Node next = cursor.tail;
				cursor=cursor.head;
				cursor.tail=next;
				next.head=cursor;
			}
			else {
				cursor=cursor.head;
				cursor.tail=null;
			}
		}
	}
	public void left() {
		if(cursor==null) return;
		if(cursor.head!=this.front) {
			cursor=cursor.head;
		}
	}
	public void right() {
		if(cursor==null) return;
		if(cursor.tail!=null) {
			cursor=cursor.tail;
		}
	}
	public void type(char x) {
		if(cursor==null) {
			cursor=new Node(front, null, x);
			front.tail=cursor;
		}
		else {
			Node next = new Node(cursor, cursor.tail, x);
			cursor.tail=next;
			if(next.tail!=null) {
				next.tail.head=next;
			}
			cursor=next;
		}
	}
}


class Node{
	Node head;
	Node tail;
	char letter;
	public Node(Node h, Node t, char x){
		this.head=h;
		this.tail=t;
		this.letter=x;
	}
	
}