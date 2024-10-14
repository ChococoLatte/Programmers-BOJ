import java.io.*;
import java.util.*;
 
public class Main
{
    static int n,m,v;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
 
        arr = new int[n+1][n+1];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
 
            arr[x][y] = arr[y][x] = 1;
        }
 
        sb = new StringBuilder();
 
        visited = new boolean[n+1];
        dfs(v);
 
        visited = new boolean[n+1];
        bfs(v);
 
        System.out.println(sb);
    }
 
    static void dfs(int start){
        visited[start] = true;
        sb.append(start+" ");
 
        for(int i=1;i<=n;i++){
            if(arr[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
 
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
 
        sb.append("\n");
        while(!q.isEmpty()){
            int tmp = q.poll();
            sb.append(tmp+" ");
 
            for(int i=1;i<=n;i++){
                if(arr[tmp][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}