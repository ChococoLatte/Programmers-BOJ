import java.io.*;
import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        
        Set<String> hs = new HashSet<>(); 
        for(char c: dirs.toCharArray()){
            int nx = x;
            int ny = y;
            
            if(c == 'U') nx++;
            else if(c == 'D') nx--;
            else if(c == 'L') ny--;
            else if(c == 'R') ny++;
            
            if(nx>5 || nx<-5 || ny>5 || ny<-5) continue;
            
            String path1 = x + "," + y + "," + nx + "," + ny;
            String path2 = nx + "," + ny + "," + x + "," + y;
            if(!hs.contains(path1)){
                hs.add(path1);
                hs.add(path2);
            }
            
            x = nx;
            y = ny;
            
        }
        return hs.size()/2;
    }
}