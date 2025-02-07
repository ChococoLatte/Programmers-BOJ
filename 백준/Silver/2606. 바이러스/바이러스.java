import java.util.*;
import java.io.*;

class Main {
    static int N,M,num;
    static boolean[] visited;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        visited = new boolean[N+1];
        dfs(1);

        System.out.println(num);
    }

    static void dfs(int v){

        visited[v] = true;

        for(int i=1;i<=N;i++){
            if(!visited[i] && arr[v][i] == 1){
                dfs(i);
                num++;
            }
        }
    }
}