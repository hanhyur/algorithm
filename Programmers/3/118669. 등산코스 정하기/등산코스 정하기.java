import java.util.*;

class Solution {
    
    public static class Node {
        int to;
        int weight;
        
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    public static class PathInfo implements Comparable<PathInfo> {
        int node;
        int intensity;
        
        public PathInfo(int node, int intensity) {
            this.node = node;
            this.intensity = intensity;
        }
        
        @Override
        public int compareTo(PathInfo o) {
            if (this.intensity == o.intensity) {
                return this.node - o.node;
            }
            
            return this.intensity - o.intensity;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<Node>[] graph = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int w = path[2];
            
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }
        
        boolean[] isSummit = new boolean[n + 1];
        Arrays.sort(summits);
        
        for (int summit : summits) {
            isSummit[summit] = true;
        }
        
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        PriorityQueue<PathInfo> pq = new PriorityQueue<>();
        
        for (int gate : gates) {
            intensity[gate] = 0;
            
            pq.offer(new PathInfo(gate, 0));
        }
        
        while (!pq.isEmpty()) {
            PathInfo current = pq.poll();
            
            if (current.intensity > intensity[current.node] || isSummit[current.node]) {
                continue;
            }
            
            for (Node neighbor : graph[current.node]) {
                int newIntensity = Math.max(current.intensity, neighbor.weight);
                
                if (newIntensity < intensity[neighbor.to]) {
                    intensity[neighbor.to] = newIntensity;
                    
                    pq.offer(new PathInfo(neighbor.to, newIntensity));
                }
            }
        }
        
        int minIntensity = Integer.MAX_VALUE;
        int bestSummit = -1;
        
        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minIntensity = intensity[summit];
                bestSummit = summit;
            }
        }
        
        return new int[]{bestSummit, minIntensity};
    }
}