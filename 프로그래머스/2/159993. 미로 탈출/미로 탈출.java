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
    static int minL1, minL2;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        minL1 = Integer.MAX_VALUE;
        minL2 = Integer.MAX_VALUE;
        
        outerLoop: for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maps[i].charAt(j)=='S'){
                    bfs(i,j,'L',true,maps);
                    break outerLoop;
                }
            }
        }
        
        int answer = -1;
        if(minL1 != Integer.MAX_VALUE && minL2 != Integer.MAX_VALUE) answer = minL1+minL2;
        return answer;
    }
    
    static void bfs(int x, int y, char f, boolean flag, String[] maps){
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[n][m];
        
        visited[x][y] = true;
        q.add(new Point(x,y,0));
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(maps[p.x].charAt(p.y) == f){
                if(flag){
                    minL1 = Math.min(minL1, p.cnt);
                    bfs(p.x,p.y,'E',false,maps);
                }else minL2 = Math.min(minL2, p.cnt);
                break;
            }
            
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(maps[nx].charAt(ny) == 'X' || visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                q.add(new Point(nx,ny,p.cnt+1));
            }
        }
    }
}