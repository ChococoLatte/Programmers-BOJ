import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int cnt = 0;
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<want.length;i++){
            hm.put(want[i], number[i]);
        }
        
        for(int i=0;i<=discount.length-10;i++){
            boolean isDone = true;
            HashMap<String, Integer> cloneHm = (HashMap<String, Integer>)hm.clone();
            for(int j=0;j<10;j++){
                if(cloneHm.getOrDefault(discount[i+j],0) == 0){
                    isDone = false;
                    break;
                }
                else cloneHm.put(discount[i+j],cloneHm.get(discount[i+j])-1);
            }
            if(isDone) cnt++;
        }
        
        return cnt;
    }
}