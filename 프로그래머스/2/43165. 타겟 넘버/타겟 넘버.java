import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        
        answer=0;
        dfs(1, +numbers[0], numbers, target);
        dfs(1, -numbers[0], numbers, target);
        
        return answer;
    }
    
    static void dfs(int idx, int cnt, int[] numbers, int target){
        
        if(idx == numbers.length){
            if(cnt == target) answer++;
            return;
        }
        
        dfs(idx+1, cnt+numbers[idx], numbers, target);
        dfs(idx+1, cnt-numbers[idx], numbers, target);
    }
}