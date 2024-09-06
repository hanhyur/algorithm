import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        List<Missile> list = new ArrayList<>();
        
        for (int i = 0; i < targets.length; i++) {
            int start = targets[i][0];
            int end = targets[i][1];
            
            list.add(new Missile(start, end));
        }
        
        list.sort(new Missile(0, 0));
        
        int prevEnd = 0;
        
        for (Missile missile : list) {
            if (prevEnd <= missile.s) {
                prevEnd = missile.e;
                answer++;
            }
        }
        
        return answer;
    }
    
    class Missile implements Comparator<Missile> {
        int s;
        int e;
        
        public Missile(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compare(Missile m1, Missile m2) {
            if (m1.e == m2.e) {
                return m1.s - m2.s;
            }
            
            return m1.e - m2.e;
        }
    }
}