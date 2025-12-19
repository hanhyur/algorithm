class Solution {
    public long solution(int w, int h) {
        long W = w;
        long H = h;
        long answer = W * H;
        
        long g = gcd(W, H);
        long broken = W + H - g;
        
        return answer - broken;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }    
}