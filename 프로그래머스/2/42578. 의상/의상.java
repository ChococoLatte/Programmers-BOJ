import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            String[] str = clothes[i];
            hm.put(str[1],hm.getOrDefault(str[1],1)+1);
        }
        
        int tot = 1;
        for(String k:hm.keySet()){
            tot*=hm.get(k);
        }
        
        return tot-1;
    }
}