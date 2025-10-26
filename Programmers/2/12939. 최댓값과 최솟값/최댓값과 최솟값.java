class Solution {
    public String solution(String s) {
        String[] parts = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < min) min = num;
            if (num > max) max = num;
        }

        return min + " " + max;
    }
}