import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N+1];
        int[] V = new int[K+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());

            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=W[i]) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-W[i]]+V[i]);
            }
        }

        System.out.println(dp[N][K]);
    }
}