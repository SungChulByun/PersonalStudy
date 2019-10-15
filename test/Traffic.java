package test;

public class Traffic {
	public void main(String args[]) {
		String[] test1 = new String[] {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
		String[] test2 = new String[] {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
		String[] test3 = new String[] {"2016-09-15 20:59:57.421 0.351s","2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		System.out.println("hi");
		System.out.println(solution(test1));
		System.out.println(solution(test2));
		System.out.println(solution(test3));
	}
	
	static float[][] data;
	static int len;
	public int solution(String[] lines) {
	      len = lines.length-2;
	      data = new float[len][2];
	      for(int i=0;i<len;i++) {
	    	  String[] tp = lines[i+1].split(" ");
	    	  data[i][0]=(float) (timeToFloat(tp[1])-eraseS(tp[2])+0.001);
	    	  data[i][1]=timeToFloat(tp[1]);
	      }
		  int answer = 0;
		  for(int i=0;i<len;i++) {
			  int mx = Math.max(howMany(i, 0), howMany(i, 1));
			  answer = Math.max(mx, answer);
		  }
	      return answer;
	}
	static float timeToFloat(String time) {
		  String[] temp = time.split(":");
		  float t1 = Float.parseFloat(temp[0]);
		  float t2 = Float.parseFloat(temp[1]);
		  float t3 = Float.parseFloat(temp[2]);
		  return (t1*3600)+(t2*60)+t3;
	}
	static float eraseS(String time) {
		return Float.parseFloat(time.substring(0, time.length()-1));
	}
	static int howMany(Integer num, Integer startend) {
		int ct=0;
		float st, et;
		if(startend==0) {
			st =(float) (data[num][0]-1+0.001);
			et =(float) (data[num][0]);
		}
		else {
			st = data[num][1];
			et = (float) (data[num][1]+1-0.001);
		}
		for(int i=0;i<len;i++) {
			if(isBetween(st, et, data[i][0])||isBetween(st, et, data[i][1])) {
				ct++;
			}
		}
		
		return ct;
	}
	static boolean isBetween(float st, float et, float tg) {
		boolean re=false;
		if(st<=tg&&tg<=et) re = true;
		return re;
	}

}