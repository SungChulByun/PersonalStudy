package SungEun;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class htmltest {
    public static void main(String args[]) throws IOException, InterruptedException{
    	String path = "C:\\Users\\user\\Desktop\\bse\\51.txt";
    	BufferedReader br = new BufferedReader(new FileReader(path));
    	String temp = br.readLine();
    	int ct=1;
    	while((temp = br.readLine())!=null) {
    		String ans[] = sungchul(temp);
    		System.out.print(ct+"; "+temp+"; ");
    		System.out.print(ans[2]+"; ");
    		System.out.print(ans[0]+"; ");
    		System.out.println(ans[1]);
    		ct++;
    		Thread.sleep(5);
    	}
    }
    public static void printlist(String[] ans) {
    	System.out.print(ans[2]+", ");
		System.out.print(ans[0]+", ");
		System.out.println(ans[1]);
    }
    public static String remove(String num) {
    	String re = "";
    	String tp[] = num.split(",");
    	for(int i=0;i<tp.length;i++) {
    		re+=tp[i];
    	}
    	return re;
    }
    public static String[] sungchul(String url) throws IOException {
    	String realurl = "https://"+url;
    	Document doc = Jsoup.connect(realurl).get();
//    	String h1 = doc.select("title").text();
//    	System.out.println(h1);
    	Elements titles = doc.select("head");
//    	System.out.println(titles);
    	String[] div = titles.toString().split("Followers, ");
    	String fol[] = div[0].split("content=\"");
    	String sfer = fol[fol.length-1];
    	sfer=sfer.replaceAll(" ", "");
    	
//    	System.out.println();
//    	System.out.println("sfer : "+sfer);
    	
    	String fedpost[] = div[1].split(" ");
    	
    	String ans[] = new String[3];
    	ans[0]=sfer;
    	ans[1]=fedpost[0];
    	ans[2]=fedpost[2];
//    	System.out.println("follower : "+fer);
//    	System.out.println("followed : "+fed);
//    	System.out.println("post : "+post);
    	return ans;

//    	//print all titles in main page
    	
//    	for(Element e: titles) {
//    		System.out.println(ct++);
//    		System.out.println("text : "+e);
//    		if(e.text().contains("Followers")) {
//    			System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><>");
//    			break;
//    		}
////    		System.out.println("html : "+e.html());
//    	}
    	//print all avaiable links on page
//    	Elements links = doc.select("a[href]");
//    	for(Element l:links) {
//    		System.out.println("link : "+l.attr("abs:href"));
//    	}
    }
}