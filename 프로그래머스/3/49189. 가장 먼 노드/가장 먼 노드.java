import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프를 인접 리스트로 표현
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보로 그래프를 구성
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        // 각 노드까지의 거리를 저장할 배열
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1); // -1로 초기화하여 아직 방문하지 않은 노드로 표시

        // BFS 탐색 시작
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        distance[1] = 0;  // 1번 노드에서 시작하므로 거리는 0

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 노드에서 연결된 다른 노드들 탐색
            for (int next : graph[current]) {
                if (distance[next] == -1) {  // 아직 방문하지 않은 노드라면
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        // 가장 멀리 떨어진 거리를 찾고 그 개수를 계산
        int maxDistance = 0;
        int count = 0;
        for (int dist : distance) {
            if (dist > maxDistance) {
                maxDistance = dist;
                count = 1;  // 새로운 최대 거리를 발견하면 카운트를 초기화
            } else if (dist == maxDistance) {
                count++;  // 같은 거리를 가진 노드가 있으면 카운트 증가
            }
        }

        return count;
    }
}