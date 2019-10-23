package test;
import java.io.*;
import java.util.*;

public class makeTestcase {
	public static void main(String args[]) {
		try {
		    OutputStream output = new FileOutputStream("C:/Users/user/Desktop/test_marathon.txt");
		    String str = "";
		    for(int i=50000;i>=1;i--) {
		    	str+=i+" ";
		    }
		    
		    byte[] by=str.getBytes();
		    output.write(by);
		    
		    
		    
		    
				
		} catch (Exception e) {
	            e.getStackTrace();
		}
	}
}