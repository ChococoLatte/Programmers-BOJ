import java.util.*;
import java.io.*;

class Solution {
    static class Node implements Comparable<Node> {
    int num;
    int x;
    int y;
    Node left;
    Node right;
    
    public Node(int num, int x, int y, Node left, Node right){
        this.num = num;
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public int compareTo(Node n){
        if(this.y == n.y){
            return this.x-n.x;
        }
        return n.y-this.y;
    }
}

    static int idx;
    static int[][] answer;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        ArrayList<Node> list = new ArrayList<>();
        for(int i=0;i<nodeinfo.length;i++){
            list.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null));
        }
        Collections.sort(list);
        
        Node root = list.get(0);
        for(int i=1;i<nodeinfo.length;i++){
            insertNode(root, list.get(i));
        }
        
        idx = 0;
        preOrder(root);
        
        idx = 0;
        postOrder(root);
        
        return answer;
    
    }
    
    static void insertNode(Node parent, Node child){
        if(parent.x>child.x){
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        }else{
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    static void preOrder(Node root){
        if(root == null) return;
        answer[0][idx++] = root.num;
        preOrder(root.left);
        preOrder(root.right);
    }
    
    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        answer[1][idx++] = root.num;
    }
}