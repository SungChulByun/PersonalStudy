package test;
import java.io.*;
import java.util.*;

public class makeTestcase {
	public static void main(String args[]) {
		try {
		    OutputStream output = new FileOutputStream("C:/Users/user/Desktop/test_rec.txt");
		    String str = "";
		    Random random = new Random();
		    for(int i=0;i<50000;i++) {
		    	if(i%10000==0) System.out.println(i);
		    	int x1 = Math.abs(random.nextInt());
		    	int x2 = Math.abs(random.nextInt());
		    	int y1 = Math.abs(random.nextInt());
		    	int y2 = Math.abs(random.nextInt());
		    	int sx = Math.min(x1, x2);
		    	int ex = Math.max(x1, x2);
		    	int sy = Math.min(y1, y2);
		    	int ey = Math.max(y1, y2);
		    	str+=sx+" "+sy+" "+ex+" "+ey+"\n";
		    }
		    
		    byte[] by=str.getBytes();
		    output.write(by);
		    System.out.println("end");
		    
		    
		    
				
		} catch (Exception e) {
	            e.getStackTrace();
		}
	}
}