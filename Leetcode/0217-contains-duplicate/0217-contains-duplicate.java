class Solution {
    // 중복이 한 번이라도 존재하면 true, 없으면 false를 출력한다
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hset = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++){
            if (hset.contains(nums[i])){
                return true;
            }

            hset.add(nums[i]);
        }

        return false;
    }
}