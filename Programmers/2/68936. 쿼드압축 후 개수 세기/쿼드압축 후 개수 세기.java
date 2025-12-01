class Solution {
    
    private int zeroCount = 0;
    private int oneCount = 0;
    
    public int[] solution(int[][] arr) {
        int n = arr.length;
        
        compress(arr, 0, 0, n);
        
        return new int[]{zeroCount, oneCount};
    }
    
    private void compress(int[][] arr, int x, int y, int size) {
        if (isUniform(arr, x, y, size)) {
            int value = arr[x][y];
            
            if (value == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            
            return;
        }
        
        int half = size / 2;
        
        compress(arr, x, y, half);
        compress(arr, x, y + half, half);
        compress(arr, x + half, y, half);
        compress(arr, x + half, y + half, half);
    }
    
    private boolean isUniform(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        
        return true;
    }
}