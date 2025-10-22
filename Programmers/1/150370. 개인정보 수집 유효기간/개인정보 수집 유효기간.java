import java.util.*;

class Solution {
    
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayValue = toDays(today);
        Map<String, Integer> termMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (String term : terms) {
            String[] parts = term.split(" ");
            
            termMap.put(parts[0], Integer.parseInt(parts[1]) * 28);
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            
            int collected = toDays(parts[0]);
            String type = parts[1];

            int expireDate = collected + termMap.get(type) - 1;
            
            if (expireDate < todayValue) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int toDays(String date) {
        String[] d = date.split("\\.");
        
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        
        return year * 12 * 28 + month * 28 + day;
    }    
}