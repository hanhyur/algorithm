import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Long> sequence = new ArrayList<>();
        sequence.add((long) k);

        while (k != 1) {
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
            
            sequence.add((long) k);
        }

        int n = sequence.size() - 1;

        double[] area = new double[n];
        for (int i = 0; i < n; i++) {
            area[i] = (sequence.get(i) + sequence.get(i + 1)) / 2.0;
        }

        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + area[i];
        }

        double[] answer = new double[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1];

            if (start > end) {
                answer[i] = -1;
            } else {
                answer[i] = prefix[end] - prefix[start];
            }
        }

        return answer;
    }
}