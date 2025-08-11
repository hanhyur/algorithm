class Solution {
    
    int signUp = 0;
    int revenue = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        int[] offPrice = new int[emoticons.length];
        
        applyDiscount(offPrice, 0, users, emoticons);
        
        answer[0] = signUp;
        answer[1] = revenue;
        
        return answer;
    }
    
    private void applyDiscount(int[] offPrice, int index, int[][] users, int[] emoticons) {
        if (index == offPrice.length) {
            calculateProfit(offPrice, users, emoticons);
            
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            offPrice[index] = i;
            
            applyDiscount(offPrice, index + 1, users, emoticons);
        }
    }
    
    private void calculateProfit(int[] offPrice, int[][] users, int[] emoticons) {
        int count = 0;
        int discountRevenue = 0;
        
        for (int[] user : users) {
            int discount = user[0];
            int price = user[1];
            int sum = 0;
            
            for (int i = 0; i < offPrice.length; i++) {
                if (offPrice[i] >= discount) {
                    sum += (emoticons[i] / 100) * (100 - offPrice[i]);
                }
            }
            
            if (sum >= price) {
                count++;
            } else {
                discountRevenue += sum;
            }
        }
        
        if (count > signUp) {
            signUp = count;
            revenue = discountRevenue;
            
            return;
        } else if (count == signUp) {
            if (revenue < discountRevenue) {
                revenue = discountRevenue;
            }
        }
    }
}