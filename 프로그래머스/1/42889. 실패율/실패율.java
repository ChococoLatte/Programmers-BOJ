import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int x;
    double y;
    
    public Node(int x, double y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Node n){
        if(this.y == n.y) return this.x - n.x;
        else return Double.compare(n.y,this.y);
    }
    
}

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] fail = new int[N];
        for(int i:stages){
            if(i>N) continue;
            fail[i-1]++;
        }
        
        int total = stages.length;
        ArrayList<Node> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            double rate = 0;
            
            if(total !=0){
                rate = (double) fail[i]/total;
            }
            list.add(new Node(i+1,rate));
            total -= fail[i];
        }
        
        Collections.sort(list);
        return list.stream().mapToInt(i->i.x).toArray();
    }
}