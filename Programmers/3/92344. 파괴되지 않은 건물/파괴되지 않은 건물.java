class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        int[][] change = new int[n + 1][m + 1];
        
        for (int[] s : skill) {
            int type = s[0];
            int row1 = s[1], col1 = s[2];
            int row2 = s[3], col2 = s[4];
            int degree = s[5];
            
            int value = (type == 1) ? -degree : degree;
            
            change[row1][col1] += value;
            change[row1][col2 + 1] -= value;
            change[row2 + 1][col1] -= value;
            change[row2 + 1][col2 + 1] += value;
        }
        
        for (int row = 0; row < n; row++) {
            for (int col = 1; col < m; col++) {
                change[row][col] += change[row][col - 1];
            }
        }
        
        for (int col = 0; col < m; col++) {
            for (int row = 1; row < n; row++) {
                change[row][col] += change[row - 1][col];
            }
        }
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (board[row][col] + change[row][col] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}