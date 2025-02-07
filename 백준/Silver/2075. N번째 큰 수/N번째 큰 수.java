import java.util.*;
import java.io.*;

class Main {
    static class Point implements Comparable<Point> {
        int val;

        public Point(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Point p) {
            return this.val - p.val;  // 오름차순으로 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        // 최소 힙 (PriorityQueue)으로 초기화
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                pq.offer(new Point(v));  // 우선순위 큐에 값 삽입
                
                // 큐의 크기가 N보다 커지면 가장 작은 값 삭제
                if (pq.size() > N) {
                    pq.poll();
                }
            }
        }

        // N번째로 큰 값은 최소 힙에서 가장 작은 값
        System.out.println(pq.poll().val);
    }
}