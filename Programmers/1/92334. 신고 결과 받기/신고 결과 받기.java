import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        Map<String, Set<String>> reportedMap = new HashMap<>();
        
        for (String r : reportSet) {
            String[] split = r.split(" ");
            String reporter = split[0];
            String target = split[1];
            
            reportedMap.putIfAbsent(target, new HashSet<>());
            reportedMap.get(target).add(reporter);
        }

        Set<String> suspended = new HashSet<>();
        
        for (Map.Entry<String, Set<String>> entry : reportedMap.entrySet()) {
            if (entry.getValue().size() >= k) {
                suspended.add(entry.getKey());
            }
        }

        Map<String, Integer> mailCount = new HashMap<>();
        
        for (String id : id_list) mailCount.put(id, 0);

        for (String target : suspended) {
            for (String reporter : reportedMap.get(target)) {
                mailCount.put(reporter, mailCount.get(reporter) + 1);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.get(id_list[i]);
        }
        
        return answer;
    }
}