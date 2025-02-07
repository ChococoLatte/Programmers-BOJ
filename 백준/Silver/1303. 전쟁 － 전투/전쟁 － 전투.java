import java.util.*;
import java.io.*;

class Main {
    static int N,M,num,WCount,BCount;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        arr = new char[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]){
                    num = 1;
                    dfs(i,j);
                    if(arr[i][j] == 'B'){
                        BCount+=(num*num);
                    }else{
                        WCount+=(num*num);
                    }
                }
            }
        }

        System.out.println(WCount+" "+BCount);
    }

    static void dfs(int x, int y){

        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
            if(visited[nx][ny]) continue;
            if(arr[nx][ny]!=arr[x][y]) continue;

            dfs(nx,ny);
            num++;
        }
    }
}