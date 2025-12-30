import java.util.*;

class Solution {
    
    static class Group {
        int d, i, s;
        int score;
        
        Group(int d, int i, int s) {
            this.d = d;
            this.i = i;
            this.s = s;
            this.score = 25 * d + 5 * i + s;            
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];
        int limit = Math.min(minerals.length, totalPicks * 5);

        List<Group> groups = new ArrayList<>();
        for (int idx = 0; idx < limit; idx += 5) {
            int d = 0, i = 0, s = 0;
            for (int k = idx; k < idx + 5 && k < limit; k++) {
                String m = minerals[k];
                if ("diamond".equals(m)) d++;
                else if ("iron".equals(m)) i++;
                else s++;
            }
            groups.add(new Group(d, i, s));
        }        
        
        groups.sort((a, b) -> Integer.compare(b.score, a.score));
        
        for (Group g : groups) {
            int pickType = -1;
            if (picks[0] > 0) {
                pickType = 0;
                picks[0]--;
            } else if (picks[1] > 0) {
                pickType = 1;
                picks[1]--;
            } else if (picks[2] > 0) {
                pickType = 2;
                picks[2]--;
            } else {
                break;
            }
            
            if (pickType == 0) {
                answer += (g.d + g.i + g.s);
            } else if (pickType == 1) {
                answer += 5 * g.d + (g.i + g.s);
            } else {
                answer += 25 * g.d + 5 * g.i + g.s;
            }
        }
        
        return answer;
    }
}