import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<commands.length;i++){
            int[] edge = commands[i];
            
            int x = edge[0]-1;
            int y = edge[1]-1;
            int idx = edge[2]-1;
            
            int[] arr = new int[y-x+1];
            for(int j=x;j<=y;j++){
                arr[j-x] = array[j];
            }
            
            Arrays.sort(arr);
            
            answer.add(arr[idx]);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}