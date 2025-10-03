import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> hof = new ArrayList<>(k);
		
        for (int i = 0; i < score.length; i++) {
            hof.add(score[i]);
            
            Collections.sort(hof);
            
            if (hof.size() > k) {
                hof.remove(0);
            }
            
            answer[i] = hof.get(0);
        }
        
        return answer;
    }
}