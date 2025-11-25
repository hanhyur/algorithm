class Solution {
    public int solution(String word) {
        int answer = 0;
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int[] weights = {781, 156, 31, 6, 1};

        for (int i = 0; i < word.length(); i++) {
            int idx = "AEIOU".indexOf(word.charAt(i));
            answer += idx * weights[i] + 1;
        }
        
        return answer;
    }
}