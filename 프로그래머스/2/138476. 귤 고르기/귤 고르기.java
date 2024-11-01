import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<tangerine.length;i++){
            hs.add(tangerine[i]);
        }
        
        int[] number = new int[hs.size()];
        Arrays.sort(tangerine);
        
        int idx = 0;
        int type = tangerine[0];
        int cnt = 1;
        for(int i=1;i<tangerine.length;i++){
            if(type == tangerine[i]) cnt++;
            else{
                number[idx] = cnt;
                idx++;
                type = tangerine[i];
                cnt=1;
            }
            
            if(i == tangerine.length-1) number[idx] = cnt;
        }
        
        Arrays.sort(number);
        int tot=0;
        cnt=0;
        for(int i=number.length-1;i>=0;i--){
            cnt++;
            if(tot+number[i]>=k) break;
            else tot+=number[i];
        }
        
        return cnt;
    }
}