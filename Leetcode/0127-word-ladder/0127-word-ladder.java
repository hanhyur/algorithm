class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return steps;
                }

                for (String nextWord : getNeighbors(word, wordSet)) {
                    queue.offer(nextWord);

                    wordSet.remove(nextWord);
                }
            }

            steps++;
        }

        return 0;
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char origin = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == origin) continue;

                chars[i] = c;

                String newWord = new String(chars);

                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }

            chars[i] = origin;
        }

        return neighbors;
    }
}