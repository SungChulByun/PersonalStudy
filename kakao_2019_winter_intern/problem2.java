package winter_intern_2019;

import java.util.*;

public class problem2 {
	
	public static void main(String args[]) {
		String test = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		
		int[] answer = solution(test); 
		
		printList(answer);
	}
	
	public static int[] solution(String s) {
		
        List<Tuple> tupleList = translate(s);

        
		Set<Integer> check = new HashSet<>();
        
		int[] answer = new int[tupleList.size()];
        for(int i=0;i<answer.length;i++) {
        	for(int j=0;j<tupleList.get(i).list.size();j++) {
        		if(!check.contains(tupleList.get(i).list.get(j))) {
        			answer[i] = tupleList.get(i).list.get(j);
        			check.add(tupleList.get(i).list.get(j));
        			continue;
        		}
        		
        	}
        }
        
        
        return answer;
    }
	
	public static List<Tuple> translate(String s){
		List<Tuple> output = new ArrayList<>();
	
		
		String[] middle = s.split("\\},\\{");
		
//		printList(middle);
		if(middle.length==1) {
			String fix = middle[0].substring(2, middle[0].length()-2);
			Tuple tuple = new Tuple(new String[] {fix});
			output.add(tuple);
		}
		else {
			for(int i=0;i<middle.length;i++) {
				String fix = middle[i];
				if(i==0) {
					fix = fix.substring(2);
					
					
				}
				else if(i==middle.length-1) {
//					System.out.println(fix);
					fix = fix.substring(0, fix.length()-2);
//					System.out.println(fix);
					
				}
				
				String[] temp = translateToStringList(fix);
				
				Tuple tuple = new Tuple(temp);
				output.add(tuple);
				
			}
			Collections.sort(output);
			
		}
		return output;
	}
	
	public static void printList(Object object) {
		if(object instanceof Collection) {
			Collection list = (Collection) object;
			Iterator iterator = list.iterator();
			while(iterator.hasNext()) {
				System.out.print(iterator.next()+" ");
			}
			System.out.println();
		}
		else if(object instanceof int[]) {
			int[] list = (int[]) object;
			for(int i=0;i<list.length;i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println();
		}
		else if(object instanceof String[]) {
			String[] list = (String[]) object;
			for(int i=0;i<list.length;i++) {
				System.out.println(i + " : " + list[i]);
			}
			System.out.println();
		}
		else {
			System.out.println("class : " + object.getClass());
		}
	}
	
	public static String[] translateToStringList(String s) {
		String[] output = s.split(",");
		return output;
	}
	
	
	
	
	static class Tuple implements Comparable<Tuple>{
		List<Integer> list;

		public Tuple(String[] input) {
			this.list = new ArrayList<>();
			for(int i=0;i<input.length;i++) {
				this.list.add(Integer.parseInt(input[i]));
			}
		}
		
		@Override
		public int compareTo(Tuple o) {
			// TODO Auto-generated method stub
			return this.list.size() - o.list.size();
		}
		
	}
}
