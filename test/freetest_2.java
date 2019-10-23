package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class freetest_2 {
    public static void main(String[] args) throws IOException{
    	String path = "C:\\Users\\user\\Desktop\\bse\\test_61.txt";
    	BufferedReader br = new BufferedReader(new FileReader(path));
    	String temp = br.readLine();
    	while((temp = br.readLine())!=null) {
    		System.out.println(temp);
    	}
    }
}