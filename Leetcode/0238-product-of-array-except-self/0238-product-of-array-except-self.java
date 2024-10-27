class Solution {
    // 자신(현재 인덱스)을 제외한 나머지 요소들을 곱한 값을 요소로 가지는 배열을 구한다.
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        
        int cur = 1;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                cur *= nums[i - 1];
            }
            
            ans[i] = cur;
        }
        
        cur = 1;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i < nums.length - 1) {
                cur *= nums[i + 1];
            }
            
            ans[i] *= cur;
        }
        
        return ans;
    }
}