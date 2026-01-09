class Solution {
    public int solution(String name) {
        int length = name.length();
        int answer = 0;

        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        int move = length - 1;

        for (int i = 0; i < length; i++) {
            int next = i + 1;

            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            int rightThenLeft = i * 2 + (length - next);
            int leftThenRight = (length - next) * 2 + i;

            move = Math.min(move, Math.min(rightThenLeft, leftThenRight));
        }

        return answer + move;
    }
}