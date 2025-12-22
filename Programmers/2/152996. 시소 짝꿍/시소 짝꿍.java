import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Map<Integer, Long> count = new HashMap<>();
        long answer = 0;

        for (int w : weights) {
            count.put(w, count.getOrDefault(w, 0L) + 1);
        }

        for (long c : count.values()) {
            if (c >= 2) {
                answer += c * (c - 1) / 2;
            }
        }

        for (int w : count.keySet()) {
            long c = count.get(w);

            if (w * 2 % 3 == 0) {
                int t = w * 2 / 3;
                if (t != w && count.containsKey(t))
                    answer += c * count.get(t);
            }

            if (w * 2 % 4 == 0) {
                int t = w * 2 / 4;
                if (t != w && count.containsKey(t))
                    answer += c * count.get(t);
            }

            if (w * 3 % 4 == 0) {
                int t = w * 3 / 4;
                if (t != w && count.containsKey(t))
                    answer += c * count.get(t);
            }
        }

        return answer;
    }
}