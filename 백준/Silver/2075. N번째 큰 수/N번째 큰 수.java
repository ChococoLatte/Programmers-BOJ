import java.util.*;
import java.io.*;

class Main {
    static class Point implements Comparable<Point>{
        int val;

        public Point(int val){
            this.val = val;
        }

        @Override
        public int compareTo(Point p){
            return p.val-this.val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Point> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int v = Integer.parseInt(st.nextToken());
                list.add(new Point(v));
            }
        }

        Collections.sort(list);
        System.out.println(list.get(N-1).val);
    }
}