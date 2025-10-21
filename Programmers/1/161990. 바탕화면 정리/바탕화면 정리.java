class Solution {
    public int[] solution(String[] wallpaper) {
        int rows = wallpaper.length;
        int cols = wallpaper[0].length();

        int minR = rows, minC = cols;
        int maxR = -1,  maxC = -1;
        
        for (int r = 0; r < rows; r++) {
            String line = wallpaper[r];
            for (int c = 0; c < cols; c++) {
                if (line.charAt(c) == '#') {
                    if (r < minR) minR = r;
                    if (c < minC) minC = c;
                    if (r > maxR) maxR = r;
                    if (c > maxC) maxC = c;
                }
            }
        }
        
        return new int[] { minR, minC, maxR + 1, maxC + 1 };
    }
}