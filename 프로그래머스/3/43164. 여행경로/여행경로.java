import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<String> list;
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", 0, tickets);
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    static void dfs(String start, String path, int depth, String[][] tickets){
        
        if(depth == tickets.length){
            list.add(path);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
           
            if(!visited[i]){
                String x = tickets[i][0];
                String y = tickets[i][1];
                
                if(x.equals(start)){
                    visited[i] = true;
                    dfs(y, path+" "+y, depth+1, tickets);
                    visited[i] = false;
                }
            }
        }
    }
}