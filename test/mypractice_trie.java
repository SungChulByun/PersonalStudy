package test;
import java.util.*;
public class mypractice_trie {
	public static void main(String args[]){
		trie root = new trie();
		root.isroot=true;
		root.add("asdfasdf");
		root.add("asdfas");
		root.add("abcdefg");
		root.add("abccccc");
		System.out.println(root.type("abccccc"));
	}
}

class trie{
	trie[] data = new trie[26];
	boolean isroot=false;
	boolean hasnext=false;
	public void add(String word) {
		trie cur=new trie();
		if(this.isroot) {
			if(this.data[chartoint(word.charAt(0))]!=null) {
				this.hasnext=true;
			}
			else {
				this.data[chartoint(word.charAt(0))]=new trie();
			}
			cur = this.data[chartoint(word.charAt(0))];
		}
		int len=1;
		while(len<word.length()) {
			if(cur.data[chartoint(word.charAt(len))]!=null) {
				cur.hasnext=true;
			}
			else {
				cur.data[chartoint(word.charAt(len))]=new trie();
			}
			cur=cur.data[chartoint(word.charAt(len))];
			len++;
		}
		
	}
	public int type(String word) {
		int len=0;
		trie cur=this.data[chartoint(word.charAt(len))];
		len++;
		while(len<word.length()){
			if(!cur.hasnext) {
				break;
			}
			cur=cur.data[chartoint(word.charAt(len))];
			len++;
		}
		return len;
	}
	static int chartoint(char x) {
		return x-'a';
	}
}