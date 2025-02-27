import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;
        int size = priorities.length - 1;

        Queue<Integer> que = new LinkedList<>();

        for (int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        
        while (!que.isEmpty()) {
            int i = que.poll();

            if (i == priorities[size - answer]) {
                answer++;
                l--;

                if (l < 0) {
                    break;
                }
            } else {
                que.add(i);
                l--;

                if (l < 0) {
                    l = que.size() - 1;
                }  
            }
            
        }

        return answer;
    }
}