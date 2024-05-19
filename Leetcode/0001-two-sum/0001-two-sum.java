class Solution {
    // target을 만들 수 있는 nums의 인덱스를 담은 배열을 출력
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(nums[j - i] + nums[j] == target) {
                    return new int[]{j - i, j};   
                }
            }
        }
        
        return answer;
    }
}