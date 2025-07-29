import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String bin = Long.toBinaryString(numbers[i]);
            int treeSize = getTreeSize(bin.length());
            String paddedBin = padBin(bin, treeSize);
            
            answer[i] = isValidTree(paddedBin, 0, treeSize - 1) ? 1 : 0;
        }
        
        return answer;
    }
    
    private static int getTreeSize(int length) {
        int size = 1;
        
        while (size < length) {
            size = size * 2 + 1;
        }
        
        return size;
    }
    
    private static String padBin(String bin, int treeSize) {
        int padding = treeSize - bin.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < padding; i++) {
            sb.append("0");
        }
        
        sb.append(bin);
        
        return sb.toString();
    }
    
    private static boolean isValidTree(String bin, int start, int end) {
        if (start > end) return true;
        
        int mid = (start + end) / 2;
        char root = bin.charAt(mid);
        
        if (root == '0') {
            for (int i = start; i <= end; i++) {
                if (bin.charAt(i) == '1') return false;
            }
        }
        
        return isValidTree(bin, start, mid - 1) && isValidTree(bin, mid + 1, end);
    }
}