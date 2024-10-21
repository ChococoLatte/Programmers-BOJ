import java.io.*;
import java.util.*;

class Solution {
    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    static ArrayList<String> list;
    public int solution(String word) {
        
        list = new ArrayList<>();
        dfs(0,"");
        
        return list.indexOf(word)+1;
        
    }
    
    static void dfs(int idx, String s){
        if(idx>=5) return;
        
        for(int i=0;i<5;i++){
            list.add(s+alphabet[i]);
            dfs(idx+1, s+alphabet[i]);
        }
    }
}