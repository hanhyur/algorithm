class Solution {
    
    private int maxDiff;
    private int[] best;
    
    public int[] solution(int n, int[] info) {
        maxDiff = -1;
        best = new int[11];
        int[] cur = new int[11];
        
        dfs(0, n, info, cur);
        
        if (maxDiff <= 0) {
            return new int[] {-1};
        }
        
        return best;
    }
    
    private void dfs(int idx, int arrowsLeft, int[] info, int[] cur) {
        if (idx == 11) {
            cur[10] += arrowsLeft;
            int diff = calcDiff(info, cur);
            
            if (diff > 0) {
                if (diff > maxDiff || (diff == maxDiff && isBetter(cur, best))) {
                    maxDiff = diff;
                    best = cur.clone();
                }
            }
            
            cur[10] -= arrowsLeft;
            return;
        }
        
        int need = info[idx] + 1;
        
        if (arrowsLeft >= need) {
            cur[idx] = need;
            dfs(idx + 1, arrowsLeft - need, info, cur);
            cur[idx] = 0;
        }
        
        dfs(idx + 1, arrowsLeft, info, cur);
    }
    
    private int calcDiff(int[] info, int[] cur) {
        int lion = 0;
        int apeach = 0;
        
        for (int i = 0; i < 11; i++) {
            int score = 10 - i;
            
            if (cur[i] == 0 && info[i] == 0) {
                continue;
            }
            
            if (cur[i] > info[i]) {
                lion += score;
            } else {
                apeach += score;
            }
        }
        
        return lion - apeach;
    }
    
    private boolean isBetter(int[] cand, int[] best) {
        for (int i = 10; i >= 0; i--) {
            if (cand[i] != best[i]) {
                return cand[i] > best[i];
            }
        }
        
        return false;
    }
}