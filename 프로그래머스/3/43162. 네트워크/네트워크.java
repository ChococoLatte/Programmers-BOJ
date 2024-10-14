import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int cnt = 0;
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(visited[i]) continue;
            dfs(i,n,computers);
            cnt++;
        }
        
        return cnt;
    }
    
    static void dfs(int v, int n, int[][] computers){
        visited[v] = true;
        for(int i=1;i<=n;i++){
            if(computers[v-1][i-1] == 1 && !visited[i]) dfs(i,n,computers);
        }
    }
}