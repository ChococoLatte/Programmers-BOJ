import java.util.*;
import java.io.*;

class Main {
    static class Node implements Comparable<Node>{
        int length;
        String word;

        public Node(int length, String word){
            this.length = length;
            this.word = word;
        }

        @Override
        public int compareTo(Node n){
            if(this.length == n.length) return this.word.compareTo(n.word);
            return this.length-n.length;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Node> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String s = br.readLine();

            list.add(new Node(s.length(),s));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0).word).append("\n");
        for(int i=1;i<list.size();i++){
            if(!list.get(i-1).word.equals(list.get(i).word)) sb.append(list.get(i).word).append("\n");
        }
        System.out.println(sb);
    }
}