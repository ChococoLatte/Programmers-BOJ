import java.util.*;
import java.io.*;

class Main {
    static int N,M;
    static int[] num;
    static boolean[] isSelected;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[M];
        isSelected = new boolean[N];

        sb = new StringBuilder();
        perm(0);

        System.out.println(sb);
        
    }

    static void perm(int cnt){

        if(cnt == M){
            for(int nm:num){
                sb.append(nm).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(isSelected[i]) continue;

            isSelected[i] = true;
            num[cnt] = i+1;
            perm(cnt+1);
            isSelected[i] = false;
        }
    }
}