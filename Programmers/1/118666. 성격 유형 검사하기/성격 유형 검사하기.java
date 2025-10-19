import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> scoreMap = new HashMap<>();

        for (char type : new char[]{'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'}) {
            scoreMap.put(type, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            char disagreeType = survey[i].charAt(0);
            char agreeType = survey[i].charAt(1);
            int choice = choices[i];

            if (choice < 4) {
                scoreMap.put(disagreeType, scoreMap.get(disagreeType) + (4 - choice));
            } else if (choice > 4) {
                scoreMap.put(agreeType, scoreMap.get(agreeType) + (choice - 4));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(scoreMap.get('R') >= scoreMap.get('T') ? 'R' : 'T');
        result.append(scoreMap.get('C') >= scoreMap.get('F') ? 'C' : 'F');
        result.append(scoreMap.get('J') >= scoreMap.get('M') ? 'J' : 'M');
        result.append(scoreMap.get('A') >= scoreMap.get('N') ? 'A' : 'N');

        answer = result.toString();
        
        return answer;
    }
}