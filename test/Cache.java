package test;
import java.util.*;


public class Cache {
	
	public static void main(String args[]) {
		String[] input = new String[] {"Enter uid1234 Muzi", "Enter uid4567 P","Leave uid1234","Enter uid1234 aa","Change uid4567 Ryan", "Leave uid1234", "Leave uid4567"};
		String[] result = solution(input);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
	static int len, n;
	static HashMap<String, String> map = new HashMap<String, String>();
	public static String[] solution(String[] record) {
        len = record.length;
        n=0;
        for(int i=0;i<len;i++) {
        	int enter = isEnter(record[i]);
//        	System.out.println(record[i]+" : "+enter);
        	String id = record[i].split("\\s+")[1];
        	if(enter!=-1) {
//        		System.out.println("id : "+idtoint(id));
//        		System.out.println("name : "+record[i].split(" ")[2]);
            	map.put(id, record[i].split("\\s+")[2]);
        	}
        	if(enter!=2) n++;
        }
        String[] answer = new String[n];
        int ct=0;
        for(int i=0;i<len;i++) {
        	int enter = isEnter(record[i]);
        	if(enter<2) {
            	answer[ct]=toFinalForm(record[i]);
            	ct++;
        	}
        }
        return answer;
    }
	static String toFinalForm(String x) {
		String temp="";
		String[] data = x.split("\\s+");
		int enter = isEnter(data[0]);
		String id = data[1];
		temp += map.get(id)+"님이 ";
		if(enter==1) {
			temp+="들어왔습니다.";
		}
		else if(enter == -1){
			temp+="나갔습니다.";
		}
		return temp;
	}
	static int isEnter(String x) {
		String y = x.split("\\s+")[0];
		String E = "Enter";
		String C = "Change";
		if (y.equals(E)) return 1;
		else if (y.equals(C)) return 2;
		else return -1;
	}
}