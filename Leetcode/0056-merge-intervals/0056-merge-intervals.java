class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (current[1] < intervals[i][0]) {
                result.add(current);
                current = intervals[i];

                continue;
            }

            current[1] = Math.max(current[1], intervals[i][1]);
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}