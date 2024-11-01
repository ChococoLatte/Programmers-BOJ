import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        
        Arrays.sort(d);
        int cnt = 0;
        int tot = 0;
        for(int i=0;i<d.length;i++){
            if(tot+d[i]>budget) break;
            else{
                cnt++;
                tot+=d[i];
            }
        }
        
        return cnt;
    }
}