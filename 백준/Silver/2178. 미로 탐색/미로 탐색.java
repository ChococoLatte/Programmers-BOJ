import java.util.*;
import java.io.*;

class Main {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point p){
            return this.cnt - p.cnt;
        }
    }
    static int N,M,tot;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        visited = new boolean[N][M];
        bfs(0,0);

        System.out.println(tot);
        
    }

    static void bfs(int x, int y){

        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Point(x,y,1));

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x == N-1 && p.y == M-1){
                tot = p.cnt;
                return;
            }

            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(visited[nx][ny] || arr[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.add(new Point(nx,ny,p.cnt+1));
            }
        }
    }
}