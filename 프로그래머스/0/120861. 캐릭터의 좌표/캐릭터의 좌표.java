import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public int[] solution(String[] keyinput, int[] board) {
        
        int x = 0;
        int y = 0;
        
        for(int i=0;i<keyinput.length;i++){
            int nx = x+dx[movePos(keyinput[i])];
            int ny = y+dy[movePos(keyinput[i])];
            
            if(nx<-board[0]/2 || nx>board[0]/2 || ny<-board[1]/2 || ny>board[1]/2) continue;
            
            x = nx;
            y = ny;
            
        }
        
        return new int[] {x,y};
    }
    
    static int movePos(String str){
        if(str.equals("up")) return 0;
        else if(str.equals("down")) return 1;
        else if(str.equals("left")) return 2;
        else return 3;
    }
}