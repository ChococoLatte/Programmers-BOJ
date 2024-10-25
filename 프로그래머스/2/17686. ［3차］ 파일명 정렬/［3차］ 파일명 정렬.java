import java.io.*;
import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int idx;
        String file;
        String head;
        int num;
       
        
        public Node(int idx, String file, String head, int num){
            this.idx = idx;
            this.file = file;
            this.head = head;
            this.num = num;
        }
        
        @Override
        public int compareTo(Node n){
            if(this.head.equals(n.head)){
                if(this.num == n.num) return this.idx-n.idx;
                return this.num-n.num;
            }
            
            return this.head.compareTo(n.head);
        }
    }
    
    public String[] solution(String[] files) {
        
        ArrayList<Node> list = new ArrayList<>();
        
        for(int i=0;i<files.length;i++){
            String file = files[i];
            
            String head = "";
            String number = "";
            boolean flag = false;
            for(int j=0;j<file.length();j++){
                if(Character.isDigit(file.charAt(j))){
                    flag = true;
                    number+=file.charAt(j);
                }else{
                    if(!flag) head+=file.charAt(j);
                    else break;
                }
            }
            list.add(new Node(i, file, head.toUpperCase(), Integer.parseInt(number)));
        }
        
         Collections.sort(list);
         String[] answer = new String[files.length];
         for(int i=0;i<files.length;i++){
            answer[i] = list.get(i).file;
         }
            
         return answer;
    }
}