import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] end = new int[100];
        int day = -1;

        for(int i = 0; i < progresses.length; i++) {
            while(progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }

            end[day]++;
        }
        
        return Arrays.stream(end).filter(i -> i != 0).toArray();
    }
}