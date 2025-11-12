class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr2[0].length;
        int k = arr1[0].length;
        
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                
                for (int x = 0; x < k; x++) {
                    sum += arr1[i][x] * arr2[x][j];
                }
                
                result[i][j] = sum;
            }
        }
        
        return result;
    }
}