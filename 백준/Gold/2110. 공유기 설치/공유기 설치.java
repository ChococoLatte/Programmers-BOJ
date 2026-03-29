import java.io.*;
import java.util.*;

public class Main {
    static int countNum(int[] arr, int N, long distance){
        int count = 1;
        int last = arr[0];
        for(int i=1;i<N;i++){
            if(arr[i]-last>=distance){
                count++;
                last = arr[i];
            }
        }
        
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        long left = 1;
        long right = arr[N-1]-arr[0];
        long answer = 0;
        while(left<=right){
            long mid = (left+right)/2;
            if(countNum(arr, N, mid)>=C){
                answer = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
}