import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        
        return nums.length/2>hs.size()?hs.size():nums.length/2;
    }
}