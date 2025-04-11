class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int minDifference = Integer.MAX_VALUE;
        int closestSum = 0;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                int currentDifference = Math.abs(currentSum - target);

                if (currentDifference < minDifference) {
                    minDifference = currentDifference;
                    closestSum = currentSum;

                    if (minDifference == 0) {
                        return closestSum;
                    }
                }

                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                }
            }
        }

        return closestSum;
    }
}