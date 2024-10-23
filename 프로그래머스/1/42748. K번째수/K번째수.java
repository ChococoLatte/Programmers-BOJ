import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++){
            int x = commands[i][0];
            int y = commands[i][1];
            int k = commands[i][2];
            
            int[] slicedArr = Arrays.copyOfRange(array, x-1, y);
            Arrays.sort(slicedArr);
            
            answer[i] = slicedArr[k-1];
        }
        
        return answer;
    }
}