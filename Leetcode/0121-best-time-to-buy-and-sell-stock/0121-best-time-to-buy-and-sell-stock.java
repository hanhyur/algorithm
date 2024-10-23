class Solution {
    // stock을 사고 팔았을 때 가장 큰 이득을 구한다.
    public int maxProfit(int[] prices) {
        int price = Integer.MAX_VALUE, answer = 0;
        
        for (int i = 0; i < prices.length; i++) {
            // 가장 저렴한 경우를 찾는다
            price = Math.min(prices[i], price);
            
            // 차액이 가장 큰 경우를 찾는다
            answer = Math.max(answer, prices[i] - price);
        }
        
        return answer;
    }
}