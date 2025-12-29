import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> cycleSizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int current = i;
            int count = 0;

            while (!visited[current]) {
                visited[current] = true;
                current = cards[current] - 1;
                count++;
            }

            cycleSizes.add(count);
        }

        if (cycleSizes.size() < 2) return 0;

        cycleSizes.sort(Collections.reverseOrder());

        return cycleSizes.get(0) * cycleSizes.get(1);
    }
}