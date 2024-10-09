import java.util.*;

class Solution {
    
    static int MAX = 1000001;
    static int point, bar, eight;
    
    public int[] solution(int[][] edges) {
        int[] answer = {};
        
        // 배열 사용하면 속도가 일정할 수 있다.
        int[] startArr = new int[MAX];
        int[] endArr = new int[MAX];
        
        for (int[] edge : edges) {
            startArr[edge[0]]++;
            endArr[edge[1]]++;
        }
        
        for (int i = 1; i < MAX; i++) {
            if (startArr[i] >= 2) {
                if (endArr[i] == 0) {
                    point = i;
                } else {
                    eight++;
                }
            } else if (startArr[i] == 0 && endArr[i] > 0) {
                bar++;
            }
        }
        
        answer = new int[] {point, startArr[point] - bar - eight, bar, eight};
        
        return answer;
    }
    
//     public int[] solution(int[][] edges) {
//         int[] answer = new int[4];
        
//         // HashMap은 속도가 제각각
//         Map<Integer, Integer> start = new HashMap<>();
//         Map<Integer, Integer> end = new HashMap<>();
        
//         // 정점 및 그래프 판별을 위해 출발과 도착 구분
//         for (int[] edge : edges) {
//             start.put(edge[0], start.getOrDefault(edge[0], 0) + 1);
//             end.put(edge[1], start.getOrDefault(edge[1], 0) + 1);
//         }
        
//         // 나가는 간선이 2개 이상일 때, 돌아오는 게 없으면 생성한 정점, 있으면 8자 그래프
//         for (Integer node : start.keySet()) {
//             if (start.get(node) > 1) {
//                 if (!end.containsKey(node)) {
//                     answer[0] = node;
//                 } else {
//                     answer[3] += 1;
//                 }
//             }
//         }
        
//         // 들어오는 간선이 있는데, 나가는 간선이 없는 정점이 있으면 막대그래프
//         for (Integer node : end.keySet()) {
//             if (!start.containsKey(node)) {
//                 answer[2] += 1;
//             }
//         }
        
//         // 생성한 정점에서 나가는 간선 수 - 판별된 그래프 개수
//         answer[1] = start.get(answer[0]) - answer[2] - answer[3];
        
//         return answer;
//     }

}