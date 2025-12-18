import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = calculateGCD(arrayA);
        int gcdB = calculateGCD(arrayB);
        
        if (isValid(gcdA, arrayB)) {
            answer = gcdA;
        }
        
        if (isValid(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
    
    private int calculateGCD(int[] array) {
        int result = array[0];
        
        for (int i = 1; i < array.length; i++) {
            result = gcd(result, array[i]);
        }
        
        return result;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        
        return a;
    }
    
    private boolean isValid(int value, int[] targetArray) {
        for (int num : targetArray) {
            if (num % value == 0) {
                return false;
            }
        }
        
        return true;
    }
}