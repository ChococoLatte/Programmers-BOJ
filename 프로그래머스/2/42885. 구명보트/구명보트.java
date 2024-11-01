import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        int N = people.length;
        
        Arrays.sort(people);
        
        int left = 0; 
        int right = N - 1; 
        
        while (left <= right) {
            
            if (people[left] + people[right] <= limit)  left++; 
            right--; 
            cnt++; 
        }
        
        return cnt;
    }
}