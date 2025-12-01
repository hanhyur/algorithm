import java.util.*;

class Solution {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        
        makeNumbers(numbers, "", visited, set);
        
        int count = 0;
        
        for (int num : set) {
            if (isPrime(num)) {
                count++;
            }
        }
        
        return count;
    }
    
    private void makeNumbers(String numbers, String cur, boolean[] visited, Set<Integer> set) {
        if (!cur.isEmpty()) {
            set.add(Integer.parseInt(cur));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNumbers(numbers, cur + numbers.charAt(i), visited, set);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}