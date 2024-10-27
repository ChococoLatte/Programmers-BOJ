import java.util.*;
import java.io.*;

class Main {
    static int N,M,min;
    static int[][] arr;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Math.min(N,M);
        for(int i=0;i<R;i++){
            Rotate();
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void Rotate(){

        for(int t=0;t<min/2;t++){
            int x = t;
            int y = t;

            int temp = arr[x][y];

            int idx = 0;
            while(idx<4){
                int nx = x+dx[idx];
                int ny = y+dy[idx];

                if(nx>=N-t || ny>=M-t || nx<t || ny<t) idx++;
                else{
                    arr[x][y] = arr[nx][ny];
                    
                    x = nx;
                    y = ny;

                }
            }

            arr[t+1][t] = temp;
        }
    }
}