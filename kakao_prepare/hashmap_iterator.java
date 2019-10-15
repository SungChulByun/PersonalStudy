package kakao_prepare;

import java.util.*;
import java.util.Map.Entry;
public class hashmap_iterator {
	public static void main(String args[]) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<100;i++) {
			map.put(""+i, i);
		}
		int n=2;
		
		if(n==1) {
			for(Map.Entry<String, Integer> el:map.entrySet()) {
				System.out.println("key : "+el.getKey()+", value : "+el.getValue());
			}
		}
		else {
			Iterator<Entry<String, Integer>> it=map.entrySet().iterator();
			while(it.hasNext()) {
				Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it.next();
				System.out.println("key : "+pair.getKey()+", value : "+pair.getValue());
			}
		}
	}
}
