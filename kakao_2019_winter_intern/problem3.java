package winter_intern_2019;

import java.util.*;

public class problem3 {
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		
		System.out.println(solution(user_id, banned_id));
	}
	
	public static int power(int i) {
		return (int) Math.pow(2, i);
	}

	public static int solution(String[] user_id, String[] banned_id) {
		List<String> user = new ArrayList<>();
		List<String> banned = new ArrayList<>();
		
		for(String u : user_id) {
			user.add(u);
		}
		
		for(String b : banned_id){
			banned.add(b);
		}
		
        
        return solution(user, banned, new ArrayList<>());
    }
	
	public static int solution(List<String> user_id, List<String> banned_id, List<String> check) {

//		System.out.println("before");
//		System.out.print("user id : ");
//		printList(user_id);
//		System.out.print("banned_id : ");
//		printList(banned_id);
//		
//		System.out.println("=================================");
		
		int answer = 0;
		for(int i=0;i<user_id.size();i++) {
			answer += recursiveCalculate(user_id, i, banned_id, check);
		}
//		System.out.println("after");
//		System.out.print("user id : ");
//		printList(user_id);
//		System.out.print("banned_id : ");
//		printList(banned_id);
//		System.out.println("answer : " + answer);
//		System.out.println("=================================");
//		
		return answer;
	}
	

	
	public static int recursiveCalculate(List<String> user_id, int target, List<String> banned_id, List<String> check) {
		if(banned_id.size()==0) {
			if(set.contains(listToString(check))) {
//				System.out.println("cannot added : " + listToString(check));
				return 0;
			}
			else {
				set.add(listToString(check));
//				System.out.println("added : " + listToString(check));
				return 1;	
			}
		}
		else {
			if(target >= user_id.size()) {
				return 0;
			}
			else {
				if(isContained(banned_id, user_id.get(target)) >=0 ) {
					if(banned_id.size() == 1) {
						List<String> n_check = new ArrayList<>();
						for(String c : check) {
							n_check.add(c);
						}
						n_check.add(user_id.get(target));
						
						if(set.contains(listToString(n_check))) {
//							System.out.println("cannot added : " + listToString(n_check));
							return 0;
						}
						else {
							set.add(listToString(n_check));
//							System.out.println("added : " + listToString(n_check));
							return 1;	
						}
					}
					else {
						List<String> n_user_id = new ArrayList<>();
						List<String> n_banned_id = new ArrayList<>();
						List<String> n_check = new ArrayList<>();
						
						for(int i=0;i<user_id.size();i++) {
							if(i!=target) {
								n_user_id.add(user_id.get(i));
							}
						}
						for(int i=0;i<banned_id.size();i++) {
							if(i!=isContained(banned_id, user_id.get(target))) {
								n_banned_id.add(banned_id.get(i));
							}
						}
						
						for(String c : check) {
							n_check.add(c);
						}
						n_check.add(user_id.get(target));
						
						return solution(n_user_id, n_banned_id, n_check);
					}
				}
				else {
					return 0;
				}
			}
		}
	}
	
	public static int isContained(List<String> banned_id, String user) {
		for(int i=0;i<banned_id.size();i++) {
			if(isMatch(user, banned_id.get(i))) {
//				System.out.println("Match : " + banned_id.get(i) + ", " + user);
//				System.out.println("isContained : " + i);
				return i;
			}
		}
//		System.out.println("isContained : -1");
		return -1;
	}
	
	public static void printList(List<String> list) {
		if(list.size()>0) {
			System.out.println(listToString(list));
		}
		else {
			System.out.println("empty");
		}
		
	}
	
	public static String listToString(List<String> list) {
		String answer = "";
		Collections.sort(list);
		for(String s : list) {
			answer = answer + s + " ";
		}
		
		return answer;
	}
	
	public static boolean isMatch(String user, String banned) {
		if(user.length() != banned.length()) {
			return false;
		}
		else {
			int n = user.length(); 
			for(int i=0;i<n;i++) {
				if(banned.charAt(i) == '*') {
					continue;
				}
				else if (banned.charAt(i) == user.charAt(i)) {
					continue;
				}
				else {
					return false;
				}
			}
			return true;
		}
	}
}
