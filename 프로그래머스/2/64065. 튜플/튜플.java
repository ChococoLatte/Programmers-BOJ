import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length()-2);
        String[] partArray = s.split("\\},\\{");
        
        int[] answer = new int[partArray.length];
        
        int[][] arr = new int[partArray.length][];
        for(int i=0;i<partArray.length;i++){
            String[] tmpArr = partArray[i].split(",");
            
            arr[i] = new int[tmpArr.length];
            for(int j=0;j<tmpArr.length;j++){
                arr[i][j] = Integer.parseInt(tmpArr[j]);
            };
        };
        
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a.length-b.length;
            }
        });
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(answer[i]==0 && !hs.contains(arr[i][j])){
                    answer[i] = arr[i][j];
                    hs.add(arr[i][j]);
                }
            }
        }
        
        return answer;
    }
}