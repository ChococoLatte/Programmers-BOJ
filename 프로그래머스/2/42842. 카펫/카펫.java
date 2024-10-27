import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int m=0;
        int n=0;
        for(int i=1;i<=yellow;i++){
            m = i;
            n = (yellow/i);
            
            if(m<n) continue; 
            if(2*(m+n) == brown-4) break;
        }
        return new int[] {m+2,n+2};
    }
}