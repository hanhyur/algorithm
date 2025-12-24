import java.util.*;

class Solution {
    
    private List<int[]> result = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
                
        return result.toArray(new int[result.size()][]);
    }
    
    private void hanoi(int n, int from, int to, int via) {
        if (n == 0) return;
        
        hanoi(n - 1, from, via, to);
        
        result.add(new int[]{from, to});
        
        hanoi(n - 1, via, to, from);
    }
}