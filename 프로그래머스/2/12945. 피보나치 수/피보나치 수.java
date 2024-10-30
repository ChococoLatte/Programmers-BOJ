import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        
        return dp(n);
    }
    
    static int dp(int n){
       
        int[] dp = new int[n+1];
        
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i=3;i<=n;i++){
            if(dp[i]==0){
                dp[i] = (dp[i-2]+dp[i-1])%1234567;
            }
        }
        
        return dp[n];
    }
}