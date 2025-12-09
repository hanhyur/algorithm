import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        
        int value = 1;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = value++;
            }
        }
        
        int[] answer = new int[queries.length];
        
        for (int qi = 0; qi < queries.length; qi++) {
            int[] q = queries[qi];
            
            int x1 = q[0] - 1;
            int y1 = q[1] - 1;
            int x2 = q[2] - 1;
            int y2 = q[3] - 1;
            
            int minValue = rotateBorder(board, x1, y1, x2, y2);
            answer[qi] = minValue;
        }
        
        return answer;
    }
    
    private int rotateBorder(int[][] board, int x1, int y1, int x2, int y2) {
        int temp = board[x1][y1];
        int minValue = temp;
        
        for (int x = x1; x < x2; x++) {
            board[x][y1] = board[x + 1][y1];
            minValue = Math.min(minValue, board[x][y1]);
        }
        
        for (int y = y1; y < y2; y++) {
            board[x2][y] = board[x2][y + 1];
            minValue = Math.min(minValue, board[x2][y]);
        }
        
        for (int x = x2; x > x1; x--) {
            board[x][y2] = board[x - 1][y2];
            minValue = Math.min(minValue, board[x][y2]);
        }
        
        for (int y = y2; y > y1; y--) {
            board[x1][y] = board[x1][y - 1];
            minValue = Math.min(minValue, board[x1][y]);
        }
        
        board[x1][y1 + 1] = temp;
        minValue = Math.min(minValue, temp);
        
        return minValue;
    }
}