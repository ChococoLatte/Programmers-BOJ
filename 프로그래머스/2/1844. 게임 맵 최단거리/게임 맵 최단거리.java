import java.io.*;
import java.util.*;

class Solution {
    static class Point{
        int x;
        int y;
        int cnt;
        
        public Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int answer;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        answer = Integer.MAX_VALUE;
        visited = new boolean[n][m];
        bfs(0,0,1,maps);
        
        return answer == Integer.MAX_VALUE?-1:answer;
        
    }
    
    static void bfs(int x, int y, int cnt, int[][] maps){
        Queue<Point> q = new LinkedList<>();
        
        visited[x][y] = true;
        q.add(new Point(x,y,cnt));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == n-1 && p.y == m-1){
                answer = Math.min(p.cnt,answer);
                break;
            }
            
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(maps[nx][ny] == 0 || visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                q.add(new Point(nx, ny, p.cnt+1));
            }
        }
    }
}