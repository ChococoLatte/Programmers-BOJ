import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 인접 리스트를 사용하여 그래프 표현
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 구성
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        // 각 전선을 끊어서 서브트리의 크기를 비교
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            // 전선을 끊음
            graph[v1].remove((Integer) v2);
            graph[v2].remove((Integer) v1);
            
            // 하나의 서브트리의 크기를 계산
            visited = new boolean[n + 1];
            int subtreeSize = bfs(1, graph, n); // 1번 노드를 기준으로 탐색
            
            // 두 전력망의 차이를 계산
            int diff = Math.abs(subtreeSize - (n - subtreeSize));
            answer = Math.min(answer, diff);
            
            // 전선 복구
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return answer;
    }
    
    // BFS를 사용하여 서브트리의 크기를 계산
    private int bfs(int start, List<Integer>[] graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        return count;
    }
}