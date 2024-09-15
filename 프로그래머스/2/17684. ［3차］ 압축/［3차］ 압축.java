import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> hm = new HashMap<>();
        char c = 'A';
        for(int i=1;i<=26;i++){
            hm.put(String.valueOf(c++),i);
        }
        
        ArrayList<Integer> answer= new ArrayList<>();
        int i = 0;
        int idx = 27;
        int tmpIdx = 0;
        outerLoop: while(i<msg.length()){
            for(int j=i+1;j<=msg.length();j++){
                String str = msg.substring(i,j);
                if(!hm.containsKey(str)){
                    hm.put(str,idx++);
                    answer.add(tmpIdx);
                    tmpIdx = 0;
                    i+=(str.length()-1);
                    break;
                }else{
                    tmpIdx = hm.get(str);
                }
                
                if(j == msg.length()){
                    answer.add(tmpIdx);
                    break outerLoop;
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}