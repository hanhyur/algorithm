class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];

        for (char task : tasks) {
            frequency[task - 'A']++;
        }

        Arrays.sort(frequency);

        int maxFrequency = frequency[25];
        int maxCount = 1;

        for (int i = 24; i >= 0; i--) {
            if (frequency[i] != maxFrequency) {
                break;
            }

            maxCount++;
        }

        int minTime = (maxFrequency - 1) * (n + 1) + maxCount;

        return Math.max(minTime, tasks.length);
    }
}