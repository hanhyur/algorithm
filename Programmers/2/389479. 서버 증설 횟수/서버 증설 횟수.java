class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // players 배열 순회하면서
        // 각 원소의 크기 / m = 증설 서버의 수
        // 증설했다면 해당 인덱스 + k - 1까지 증설 상태
        // 원소의 크기 / 증설되어 있는 서버 갯수 * m
        // 증설 횟수 answer 늘려서 return
        int[] servers = new int[24];
        
        for (int i = 0; i < 24; i++) {
            int need = players[i] / m;
        
            if (need > servers[i]) {
                int more = need - servers[i];
                
                for (int j = i; j < i + k && j < 24; j++) {
                    servers[j] += more;
                }
                
                answer += more;
            }
        }
        
        return answer;
    }
}