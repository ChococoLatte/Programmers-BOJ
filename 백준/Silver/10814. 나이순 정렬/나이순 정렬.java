import java.io.*;
import java.util.*;

class Main {
    static class Node implements Comparable<Node>{
        int age;
        int joinDate;
        String name;

        public Node(int age, int joinDate, String name){
            this.age = age;
            this.joinDate = joinDate;
            this.name = name;
        }

        @Override
        public int compareTo(Node n){
            if(this.age == n.age) return this.joinDate-n.joinDate;
            return this.age-n.age;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Node> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            list.add(new Node(age, i, name));
            
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            Node now = list.get(i);
            
            sb.append(now.age+" "+now.name).append("\n");
        }

        System.out.println(sb);
    }
}