import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            hm.put(genres[i], hm.getOrDefault(genres[i],0)+plays[i]);
        }
        
        ArrayList<String> list = new ArrayList<>(hm.keySet());
        list.sort((val1,val2)->(hm.get(val2).compareTo(hm.get(val1))));
        
        ArrayList<Integer> unqNumList = new ArrayList<>();
        for(String s: list){
          int max = 0;
          int first = 0;
          int second = 0;
          for(int i=0;i<genres.length;i++){
              if(s.equals(genres[i])){
                  if(plays[i]>max){
                      first = i;
                      max = plays[i];
                  }
              }
          }
          unqNumList.add(first);
          max = 0;
          for(int i=0;i<genres.length;i++){
              if(s.equals(genres[i])){
                  if(i!=first && plays[i]>max){
                      second = i;
                      max = plays[i];
                  }
              }
           }
           if(max!=0) unqNumList.add(second);
        }
        
        return unqNumList.stream().mapToInt(Integer::intValue).toArray();
    }
}