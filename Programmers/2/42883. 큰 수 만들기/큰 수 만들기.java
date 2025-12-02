import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder st = new StringBuilder();
        
        for (char c : number.toCharArray()) {
            while (k > 0 && st.length() > 0 && st.charAt(st.length() - 1) < c) {
                st.deleteCharAt(st.length() - 1);
                k--;
            }
            
            st.append(c);
        }    
        
        return st.substring(0, st.length() - k);
    }
}