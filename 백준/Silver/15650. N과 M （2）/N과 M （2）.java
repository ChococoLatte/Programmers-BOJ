import java.util.*;
import java.io.*;

class Main {
    static int N,M;
    static int[] num;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[M];
        sb = new StringBuilder();
        comb(0,0);

        System.out.println(sb);

    }

    static void comb(int start, int cnt){

        if(cnt == M){
            for(int nm:num){
                sb.append(nm).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<N;i++){
            num[cnt] = i+1;
            comb(i+1,cnt+1);
        }
    }
}