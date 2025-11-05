import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] extended = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            extended[i] = elements[i % n];
        }

        Set<Integer> sumSet = new HashSet<>();

        int[] prefix = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            prefix[i] = prefix[i - 1] + extended[i - 1];
        }

        for (int length = 1; length <= n; length++) {
            for (int start = 0; start < n; start++) {
                int sum = prefix[start + length] - prefix[start];
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}