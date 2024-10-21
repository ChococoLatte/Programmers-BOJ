import java.util.*;
import java.io.*;

class Main {
    static class Node implements Comparable<Node>{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node n){
            if(this.x == n.x) return this.y-n.y;
            return this.x-n.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Node> list = new ArrayList<>();
        
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Node(x,y));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            Node now = list.get(i);
            sb.append(now.x+" "+now.y).append("\n");
        }

        System.out.println(sb);
    }
}