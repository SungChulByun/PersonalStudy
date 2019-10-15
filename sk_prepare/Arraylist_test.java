package sk_prepare;

public class Arraylist_test {
	public static void main(String args[]) {
		Arraylist list = new Arraylist();
		list.add("a");
		list.add("b");
		list.add("d");
		list.add("c");
		list.add(4, "x");
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}

class Arraylist{
	private Object data[];
	
	public void add(Object ob) {
		if(data!=null) {
			int len = this.data.length;
			Object[] re = new Object[len+1];
			for(int i=0;i<len;i++) {
				re[i]=data[i];
			}
			re[len]=ob;
			data = re;
		}
		else {
			data = new Object[] {ob};
		}
	}
	
	public void add(int pos, Object ob) {
		if(pos<=data.length) {
			int len = this.data.length;
			Object[] re = new Object[len+1];
			for(int i=0;i<pos;i++) {
				re[i]=data[i];
			}
			re[pos]=ob;
			for(int i=pos+1;i<len+1;i++) {
				re[i]=data[i-1];
			}
			data = re;
		}
		else {
			System.out.println("Error : position miss");
		}
	}
	
	public boolean contains(Object ob) {
		int len = this.data.length;
		for(int i=0;i<len;i++) {
			if(data[i].equals(ob)) return true;
		}
		return false;
	}
	
	public int size() {
		return this.data.length;
	}
	public boolean isEmpty() {
		if(data==null) return true;
		else return false;
	}
	
	public Object get(int pos) {
		if(pos<data.length)	return data[pos];
		else {
			System.out.println("Error : position miss");
			return null;
		}
	}
	public Object remove(int pos) {
		if(pos<data.length) {
			if(data.length==1) {
				Object temp=data[pos];
				data=null;
				return temp;
			}
			else {
				int len = data.length;
				Object temp = data[pos];
				Object[] re = new Object[len-1];
				for(int i=0;i<pos;i++) {
					re[i]=data[i];
				}
				for(int i=pos+1;i<len;i++) {
					re[i-1]=data[i];
				}
				data = re;
				return temp;
			}
		}
		else {
			System.out.println("Error : position miss");
			return null;
		}
	}
}