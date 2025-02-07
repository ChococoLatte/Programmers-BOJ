import java.util.*;
import java.io.*;

class Main {
    static int N,M,K,num;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            arr[x][y] = 1;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    num = 1;
                    dfs(i,j);
                    max = Math.max(max,num);
                }
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y){

        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
            if(visited[nx][ny] || arr[nx][ny] == 0) continue;

            dfs(nx,ny);
            num++;
        }
    }
}