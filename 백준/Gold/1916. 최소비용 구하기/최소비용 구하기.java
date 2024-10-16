import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y, v));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            // 현재 노드의 비용이 최소 비용이 아니면 패스
            if (now.cost > dist[now.dest]) continue;

            for (Node next : list[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        System.out.println(dist[end]);
    }
}