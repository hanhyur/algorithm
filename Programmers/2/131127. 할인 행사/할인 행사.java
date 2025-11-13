import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> target = new HashMap<>();
        for (int i = 0; i < want.length; i++)
            target.put(want[i], number[i]);

        Map<String, Integer> win = new HashMap<>();
        for (int i = 0; i < 10; i++)
            win.put(discount[i], win.getOrDefault(discount[i], 0) + 1);

        if (check(target, win)) answer++;

        for (int i = 10; i < discount.length; i++) {
            String out = discount[i - 10];
            String in  = discount[i];

            win.put(out, win.get(out) - 1);
            if (win.get(out) == 0) win.remove(out);

            win.put(in, win.getOrDefault(in, 0) + 1);

            if (check(target, win)) answer++;
        }
        
        return answer;
    }

    private boolean check(Map<String, Integer> target, Map<String, Integer> win) {
        for (String key : target.keySet()) {
            if (!win.getOrDefault(key, 0).equals(target.get(key)))
                return false;
        }
        
        return true;
    }
}