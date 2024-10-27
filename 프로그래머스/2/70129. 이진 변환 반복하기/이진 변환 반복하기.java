import java.io.*;
import java.util.*;

class Solution {
    static int[] answer;
    public int[] solution(String s) {
        
        answer = new int[2];
        
        String str = s;
        while(true){
            str = intToString(removeZero(str).length());
            if(str.equals("1")) break;
        }
        
        return answer;
    }
    
    static String removeZero(String str){
        
        String rtnStr="";
        int cnt = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '0') cnt++;
            else rtnStr+=str.charAt(i);
        }
        
        answer[1]+=cnt;
        return rtnStr;
    }
    
    static String intToString(int N){
        
        StringBuilder sb = new StringBuilder();
        while(true){
            if(N<=0) break;
            
            sb.append(String.valueOf(N%2));
            N/=2;
        }
        
        answer[0]++;
        return sb.reverse().toString();
    }
}