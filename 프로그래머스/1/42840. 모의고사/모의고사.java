import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] num = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++){
            int tot = 0;
            for(int j=0;j<answers.length;j++){
                if(num[i][j % num[i].length] == answers[j]){
                    tot++;
                }
            }
            
            if(max<tot){
                list.clear();
                list.add(i+1);
                max = tot;
            }else if(max == tot){
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}