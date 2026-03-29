import java.io.*;
import java.util.*;

public class Main {
    static long countNum(int[] arr, int N, long standard){
        long tot = 0;
        for(int i=0;i<N;i++){
            long val = arr[i] - standard;
            if(val>0){
                tot+=val;
            }
        }
        
        return tot;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long standard = 0;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            
            if(standard < val){
                standard = val;
            }
        }
        
        long left = 0;
        long right = standard;
        long answer = 0;
        while(left <= right){
            long mid = (left+right)/2;
            
            if(countNum(arr, N, mid) >= M){
                answer = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        System.out.println(answer);
    }
}