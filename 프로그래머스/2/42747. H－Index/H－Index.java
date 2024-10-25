import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        
        int max = 0;
        for(int i=0;i<citations.length;i++){
            int h = citations.length-i;
            
            if(citations[i]>=h){
                max = h;
                break;
            }
        }
        
        return max;
    }
}