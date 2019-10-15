package kakao;
import java.util.*;
public class matchingPoint {
	public static void main(String args[]) {
		String str = "blind";
		String[] pgs = new String[] {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		int result = solution(str, pgs);
		System.out.println(result);

	}
	static url[] data;
	public static int solution(String word, String[] pages) {
		HashMap<String, Double> tpoint = new HashMap<String, Double>();
        int n = pages.length;
        data = new url[n];
        for(int i=0;i<n;i++) {
        	String[] target = pages[i].toLowerCase().split(word.toLowerCase());
        	int len = target.length;
        	int bp = len-1;
        	for(int j=0;j<len-1;j++) {
        		if(target[j].length()==0||target[j+1].length()==0) {
        			bp--;
        		}
        		else if(isAlpha(target[j].charAt(target[j].length()-1))||isAlpha(target[j+1].charAt(0))) {
        			bp--;
        		}
        	}

        	int metaIndex = pages[i].indexOf("<meta property=\"og:url\"");
            int httpsIndex = pages[i].indexOf("https", metaIndex);
            int endIndex = pages[i].indexOf("\"", httpsIndex);
            String address = pages[i].substring(httpsIndex, endIndex);
        	
        	String[] tpurls = pages[i].split("<a href=\"");
        	int lnum = tpurls.length-1;
        	url newrl = new url(address, i, bp, lnum);

        	for(int j=0;j<lnum;j++) {
        		newrl.addUrl(tpurls[j+1].split("\"")[0]);
        	}
        	data[i]=newrl;
        }
        for(url rl:data) {
        	double totp=(double) rl.getBasic()/(double) rl.getLinknum();
        	for(String str:rl.linked) {
        		if(tpoint.containsKey(str)) {
        			tpoint.put(str, tpoint.get(str)+totp);
        		}
        		else {
        			tpoint.put(str, totp);
        		}
        	}
        }
        for(url rl:data) {
        	double tp=0;
        	if(tpoint.containsKey(rl.getAddress())) {
        		tp=tpoint.get(rl.getAddress());
        	}
        	rl.addTotalPoint(tp+rl.getBasic());
        }
        Arrays.sort(data);
        
//        for(int i=0;i<data.length;i++) {
//	        System.out.println("address : "+data[i].getAddress());
//	        System.out.println("linked url");
//	        for(String str:data[i].linked) {
//	        	System.out.print(str+" ");
//	        }
//	        System.out.println();
//	        System.out.println("basic point : "+data[i].getBasic());
//	        System.out.println("total point : "+data[i].getTotalpoint());
//	        System.out.println();
//        }

        
        return data[0].getNo();
    }
	static boolean isAlpha(char x) {
		if ('a'<=x&&x<='z') return true;
		else return false;
	}
}

class url implements Comparable<url>{
	private int no;
	private String address;
	private int basicpoint;
	private int linknum;
	private int linkpoint;
	Set<String> linked = new HashSet<String>();
	private double totalpoint;
	
	public url(String add, int noo, int bp, int ln) {
		this.address=add;
		this.basicpoint=bp;
		this.linknum=ln;
		this.no = noo;
		this.totalpoint=0;
	}
	
	public void setAddress(String add) {
		this.address=add;
	}
	public String getAddress() {
		return this.address;
	}
	public void setNo(int n) {
		this.no=n;
	}
	public int getNo() {
		return this.no;
	}
	public void addUrl(String rl) {
		this.linked.add(rl);
	}
	
	public double getTotalpoint() {
		return this.totalpoint;
	}
	public void addTotalPoint(double tp) {
		this.totalpoint+=tp;
	}
	
	public int getBasic() {
		return this.basicpoint;
	}
	public void setBasic(int bp) {
		this.basicpoint=bp;
	}
	public int getLinknum() {
		return this.linknum;
	}
	public void setLinknum(int ln) {
		this.linknum=ln;
	}
	public int getLinkpoint() {
		return this.linkpoint;
	}
	@Override
	public int compareTo(url rl) {
		if(rl.getTotalpoint()>this.getTotalpoint()) {
			return 1;
		}
		else if(rl.getTotalpoint()<this.getTotalpoint()) {
			return -1;
		}
		else {
			return (this.getNo()-rl.getNo());
		}
	}
	
}