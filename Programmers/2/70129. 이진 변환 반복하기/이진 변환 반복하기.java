import java.util.*;

class Solution {
    public int[] solution(String s) {
        int transformCount = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {
            int zeros = 0;
            
            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
            }
            
            zeroCount += zeros;
            
            int ones = s.length() - zeros;
            
            s = Integer.toBinaryString(ones);
            
            transformCount++;
        }

        return new int[]{transformCount, zeroCount};
    }
}