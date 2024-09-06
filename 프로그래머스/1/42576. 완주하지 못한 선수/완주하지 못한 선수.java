import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<completion.length;i++){
            hm.put(completion[i],hm.getOrDefault(completion[i],0)+1);
        }
        
        for(int i=0;i<participant.length;i++){
            if(hm.getOrDefault(participant[i],0) == 0) return participant[i];
            
            hm.put(participant[i],hm.get(participant[i])-1);
        }
        
        return null;
    }
}