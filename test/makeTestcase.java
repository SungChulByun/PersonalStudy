package test;
import java.io.*;
import java.util.*;

public class makeTestcase {
	public static void main(String args[]) {
		try {
		    OutputStream output = new FileOutputStream("C:/Users/user/Desktop/test_nim.txt");
		    String str = "";
		    for(int i=0;i<1000;i++) {
		    	str+=(i%110)+" ";
		    }
		    
		    byte[] by=str.getBytes();
		    output.write(by);
		    
		    
		    
		    
				
		} catch (Exception e) {
	            e.getStackTrace();
		}
	}
}