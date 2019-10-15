package kakao;
import java.util.*;
public class traffic {
	public static void main(String args[]) {
		String[] test1 = {"2016-09-15 01:00:04.002 2.0s",
				"2016-09-15 01:00:07.000 2s"};
		String[] test2 = {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		int result = solution(test1);
		System.out.println(result);
	}
	public static int solution(String lines[]) {
		int answer = 0;
		int n = lines.length;
		trafficdata[] data = new trafficdata[n];
		for(int i=0;i<n;i++) {
			String[] tp = lines[i].split(" ");
			double end = toDouble(tp[1]);
			double term = removes(tp[2]);
			trafficdata td = new trafficdata(end, term);
			data[i]=td;
		}
		
		for(int i=0;i<n;i++) {
			double st = data[i].getStart();
			double ed = data[i].getEnd();
			int maxs=0;
			int maxe=0;
			for(int j=0;j<n;j++) {
				if(isBetween(st, -1, data[j])) maxs++;
				if(isBetween(ed, +1, data[j])) maxe++;
			}
			int mx = Math.max(maxs, maxe);
			answer = Math.max(mx, answer);
		}
		return answer;
	}
	public static double removes(String x) {
		return Double.parseDouble(x.substring(0, x.length()-1));
	}
	public static double toDouble(String x) {
		String[] tp = x.split(":");
		double x2=Double.parseDouble(tp[2]);
		double x1=Double.parseDouble(tp[1])*60;
		double x0=Double.parseDouble(tp[1])*3600;
		return x0+x1+x2;
	}
	public static boolean isBetween(double time, int dir, trafficdata td) {
		if(dir>0) {
			if(td.getEnd()>=time+0.999&&time+0.999>=td.getStart()) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if(time-0.999>=td.getEnd()&&time-0.999<=td.getStart()) {
				return true;
			}
			else return false;
		}
	}
}

class trafficdata{
	private double start;
	private double end;
	public trafficdata(double end, double term) {
		this.end =end;
		this.start = end-term+0.001;
	}
	public double getStart() {
		return this.start;
	}
	public double getEnd() {
		return this.end;
	}
}