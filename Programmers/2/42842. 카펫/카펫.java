class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int h = 1;
        
        while ((long) h * h <= yellow) {
            if (yellow % h == 0) {
                int w = yellow / h;
                
                int totalW = w + 2;
                int totalH = h + 2;
                
                int brownCount = totalW * totalH - yellow;

                if (brownCount == brown) {
                    return new int[]{totalW, totalH};
                }
            }
            
            h++;
        }
        
        return answer;
    }
}