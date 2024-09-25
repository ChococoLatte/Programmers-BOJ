import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> recommend = new HashMap<>();
        for(int i=0;i<enroll.length;i++){
            recommend.put(enroll[i],referral[i]);
        }
        
        HashMap<String, Integer> money = new HashMap<>();
        for(int i=0;i<seller.length;i++){
            String person = seller[i];
            int price = amount[i]*100;
            money.put(person, money.getOrDefault(person,0)+price);
            while(recommend.containsKey(person)){
                if(price/10>0){
                    price/=10;
                    money.put(person, money.getOrDefault(person,0)-price);
                    person = recommend.get(person);
                    money.put(person, money.getOrDefault(person,0)+price);
                }else break;
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<enroll.length;i++){
            if(money.containsKey(enroll[i]))answer.add(money.get(enroll[i]));
            else answer.add(0);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}