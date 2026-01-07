class Solution {
    
    private int count;
    private int mask;
    
    public int solution(int n) {
        this.count = 0;
        this.mask = (1 << n) - 1;

        dfs(0, 0, 0);
        return count;
    }
    
    private void dfs(int cols, int diag1, int diag2) {
        if (cols == mask) {
            count++;
            return;
        }

        int available = (~(cols | diag1 | diag2)) & mask;

        while (available != 0) {
            int bit = available & -available;
            available -= bit;

            dfs(cols | bit,
                (diag1 | bit) << 1,
                (diag2 | bit) >> 1);
        }
    }    
}