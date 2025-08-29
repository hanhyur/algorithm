import java.util.*;

class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        // 노드 번호가 클 수 있으므로 Map을 사용하여 degree와 인접 리스트를 저장
        Map<Integer, Integer> degrees = new HashMap<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        // 모든 노드에 대해 degree와 인접 리스트 초기화
        for (int node : nodes) {
            degrees.put(node, 0);
            adj.put(node, new ArrayList<>());
        }

        // 간선 정보를 바탕으로 degree와 인접 리스트 구성
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            degrees.put(u, degrees.get(u) + 1);
            degrees.put(v, degrees.get(v) + 1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int oddEvenTreeCount = 0;
        int inverseOddEvenTreeCount = 0;
        Set<Integer> visited = new HashSet<>();

        // 모든 노드를 순회하며 아직 방문하지 않은 노드에서 탐색 시작
        for (int startNode : nodes) {
            if (visited.contains(startNode)) {
                continue;
            }

            // BFS를 사용하여 현재 트리에 속한 모든 노드를 찾음
            List<Integer> currentTreeNodes = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            
            queue.add(startNode);
            visited.add(startNode);

            while (!queue.isEmpty()) {
                int u = queue.poll();
                currentTreeNodes.add(u);

                for (int v : adj.get(u)) {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        queue.add(v);
                    }
                }
            }

            // 현재 트리에서 조건을 만족하는 노드의 수를 계산
            // 홀짝 트리 루트 후보: (번호 홀짝성 == degree 홀짝성)
            int matchCount = 0;
            for (int node : currentTreeNodes) {
                boolean isNodeNumOdd = (node % 2 != 0);
                boolean isDegreeOdd = (degrees.get(node) % 2 != 0);

                if (isNodeNumOdd == isDegreeOdd) {
                    matchCount++;
                }
            }

            // 홀짝 트리 판별: 루트 후보가 정확히 1개여야 함
            if (matchCount == 1) {
                oddEvenTreeCount++;
            }

            // 역홀짝 트리 판별: (번호 홀짝성 != degree 홀짝성)인 노드가 1개여야 함
            // 이는 전체 노드 수 - matchCount 와 같음
            int mismatchCount = currentTreeNodes.size() - matchCount;
            if (mismatchCount == 1) {
                inverseOddEvenTreeCount++;
            }
        }

        return new int[]{oddEvenTreeCount, inverseOddEvenTreeCount};
    }
}