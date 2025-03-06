import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        
        if (!wordSet.contains(target)) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(begin, 0));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            
            String word = current.word;
            int steps = current.steps;
            
            if (word.equals(target)) return steps;
            
            for (String nextWord : new ArrayList<>(wordSet)) {
                if (canTransform(word, nextWord)) {
                    queue.add(new Pair(nextWord, steps + 1));
                    
                    wordSet.remove(nextWord);
                }
            }
        }
        
        return 0;
    }
    
    private boolean canTransform(String word1, String word2) {
        int diff = 0;
        
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
            
            if (diff > 1) return false;
        }
        
        return diff == 1;
    }

    class Pair {
        String word;
        int steps;
        
        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
}