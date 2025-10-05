import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int p1 = 0;
        int p2 = 0;
        
        for (String str : goal) {            
            if (str.equals(cards1[p1])) {
                if (p1 < cards1.length - 1) {
                    p1++;
                }
                
                continue;
            }
            
            if (str.equals(cards2[p2])) {
                if (p2 < cards2.length - 1) {
                    p2++;
                }
                
                continue;
            }
            
            return "No";
        }
        
        return "Yes";
    }
}