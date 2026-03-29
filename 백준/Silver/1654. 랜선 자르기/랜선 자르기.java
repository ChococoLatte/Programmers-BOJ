import java.io.*;
import java.util.*;

public class Main {
    static long countNum(int[] arr, int k, long standard){
        long tot = 0;
        for(int i = 0; i < k; i++){
            tot += arr[i] / standard;
        }
        return tot;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        long standard = 0;

        for(int i = 0; i < K; i++){
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;
            if(standard < val){
                standard = val;
            }
        }

        long left = 1;
        long right = standard;
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            if(countNum(arr, K, mid) >= N){
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}