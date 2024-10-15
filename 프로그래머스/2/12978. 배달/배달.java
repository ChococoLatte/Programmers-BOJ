import java.io.*;
import java.util.*;

class Solution {
    static class Node{
        int dest, cost;
        
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] adjList = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge:road){
            int x = edge[0];
            int y = edge[1];
            int v = edge[2];
            
            adjList[x].add(new Node(y,v));
            adjList[y].add(new Node(x,v));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1,0));
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(dist[now.dest]<now.cost) continue;
            
            for(Node next: adjList[now.dest]){
                if(dist[next.dest]>now.cost+next.cost){
                    dist[next.dest] = now.cost+next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        
        int answer = 0;
        for(int i=1;i<=N;i++){
            if(dist[i]<=K) answer++;
        }
        
        return answer;
        
    }
}