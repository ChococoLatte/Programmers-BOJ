import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<orders.length;i++){
            String str = orders[i];
            ArrayList<String> list = new ArrayList<>();
            getComb(str,"",0,list);
            
            for(String s:list){
                hm.put(s,hm.getOrDefault(s,0)+1);
            }
            
        }
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0;i<course.length;i++){
            int max = 0;
            for(String s:hm.keySet()){
                if(s.length() == course[i] && hm.get(s)>=2) max = Math.max(max,hm.get(s));
            }
            
            for(String s:hm.keySet()){
                if(s.length() == course[i] && hm.get(s)>=2){
                    if(max == hm.get(s)) answer.add(s);
                }
            }
        }
        
        return answer.stream().sorted().toArray(String[]::new);
    }
    
    static void getComb(String str, String cur, int idx, ArrayList<String> list){
        if(idx == str.length()){
            if(!cur.isEmpty()){
                char[] charArr = cur.toCharArray();
                Arrays.sort(charArr);
                String sorted = new String(charArr);
                list.add(sorted);
            }
            return;
        }
        
        getComb(str,cur+str.charAt(idx),idx+1,list);
        getComb(str,cur,idx+1,list);
    }
}