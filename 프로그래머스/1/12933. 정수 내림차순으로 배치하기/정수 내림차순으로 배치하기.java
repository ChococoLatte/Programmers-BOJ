import java.io.*;
import java.util.*;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        Character[] arr = new Character[s.length()];
        
        for(int i=0;i<s.length();i++){
            arr[i] = s.charAt(i);
        }
        
        Arrays.sort(arr,Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}