import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> set = new LinkedHashSet<>(Arrays.asList(report));
        String[] unqRpt = set.toArray(new String[0]);

        HashMap<String, Integer> rptNum = new HashMap<>();
        for(int i=0;i<unqRpt.length;i++){
            String[] str = unqRpt[i].split(" ");
            rptNum.put(str[1],rptNum.getOrDefault(str[1],0)+1);
        }
        
        HashMap<String, Integer> mailNum = new HashMap<>();
        for(int i=0;i<unqRpt.length;i++){
            String[] str = unqRpt[i].split(" ");
            if(rptNum.get(str[1])>=k) mailNum.put(str[0], mailNum.getOrDefault(str[0],0)+1);
        }
        
        int[] answer = new int[id_list.length];
        for(int i=0;i<id_list.length;i++){
            if(mailNum.containsKey(id_list[i])) answer[i] = mailNum.get(id_list[i]);
            else answer[i] = 0;
        }
        
        return answer;
    }
}