import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;
        while(true){

            if(B<=A) break;

            if(B%2 ==0) B/=2;
            else if(B%10 == 1) B/=10;
            else break;

            answer++;
        }

        if(A!=B) answer = -2; 
            
        System.out.println(answer+1);
    }
}