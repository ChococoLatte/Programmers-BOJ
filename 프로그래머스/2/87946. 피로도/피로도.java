import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static int max;
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        max = Integer.MIN_VALUE;
        dfs(0,k,dungeons);
        
        return max;
    }
    
    static void dfs(int depth, int k, int[][] dungeons){
       
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i] = true;
                dfs(depth+1, k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
            max = Math.max(max,depth);
        }
    }
}