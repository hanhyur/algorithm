class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int quo = 0;
        int rem = 0;
        int empty = n;
        
        while (empty >= a) {
            quo = empty / a;
            rem = empty % a;
            empty = (quo * b) + rem;
            
            answer += quo * b;
        }
        
        return answer;
    }
}