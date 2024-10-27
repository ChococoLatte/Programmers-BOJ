import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        for(int i=0;i<topping.length;i++){
            hm1.put(topping[i], hm1.getOrDefault(topping[i],0)+1);
        }
        
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        for(int i=0;i<topping.length;i++){
            if(hm1.get(topping[i]) == 1) hm1.remove(topping[i]);
            else hm1.put(topping[i], hm1.get(topping[i])-1);
            
            hm2.put(topping[i], hm2.getOrDefault(topping[i],0)+1);
            
            if(hm1.size() == hm2.size()) answer++;
        }
        
        return answer;
    }
}