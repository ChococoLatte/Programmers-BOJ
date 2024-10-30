import java.io.*;
import java.util.*;

class Solution {
    int solution(int[][] land) {
        
        int n = land.length;
        int[][] dp = new int[n][4];
        for(int i=0;i<4;i++){
            dp[0][i] = land[0][i];
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<4;j++){
                int max = 0;
                for(int k=0;k<4;k++){
                    if(k == j) continue;
                     max = Math.max(max, dp[i-1][k]+land[i][j]);
                }
                dp[i][j] = max;
            }
        }
        
        int max = 0;
        for(int i=0;i<4;i++){
            max = Math.max(max,dp[n-1][i]);
        }
        
        return max;
    }
}