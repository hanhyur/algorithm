import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        for (String call : callings) {
            int i = rankMap.get(call);

            String frontPlayer = players[i - 1];
            players[i - 1] = call;
            players[i] = frontPlayer;

            rankMap.put(call, i - 1);
            rankMap.put(frontPlayer, i);
        }

        return players;
    }
}