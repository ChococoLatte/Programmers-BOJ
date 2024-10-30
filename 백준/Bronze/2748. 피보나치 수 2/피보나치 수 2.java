import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(N));
    }

    static long fibonacci(int N){

        long[] dp = new long[91];

        dp[0]=0;
        dp[1]=1;
        dp[2]=1;

        for(int i=3;i<=90;i++){
            dp[i] = dp[i-2]+dp[i-1];
        }

        return dp[N];
    }
}