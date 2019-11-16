package algorithm;
import java.util.*;
public class classSort {
	public static void main(String args[]) {
		ArrayList<student> school = new ArrayList<student>();
		school.add(new student("a", 15));
		school.add(new student("b", 14));
		school.add(new student("c", 16));
		school.add(new student("d", 13));
		school.add(new student("e", 17));
		school.add(new student("f", 13));
		for(int i=0;i<school.size();i++) System.out.println(school.get(i).name+" "+school.get(i).age);
		school.sort(new mysort());
		System.out.println();
		for(int i=0;i<school.size();i++) System.out.println(school.get(i).name+" "+school.get(i).age);
		
	}
}
class student implements Comparable<student>{
	int age;
	String name;
	public student(String n, int a) {
		age=a;
		name=n;
	}
	@Override
	public int compareTo(student a) {
		return this.age-a.age;
	}
}

class mysort implements Comparator<student>{
	public int compare(student a, student b) {
		return a.age-b.age;
	}
}