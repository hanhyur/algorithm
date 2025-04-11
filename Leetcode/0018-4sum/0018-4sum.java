class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (n < 4) {
            return result;
        }

        Arrays.sort(nums);

        long longTarget = (long) target;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            long minSum1 = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];

            if (minSum1 > longTarget) {
                break;
            }

            long maxSum1 = (long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];

            if (maxSum1 < longTarget) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                long minSum2 = (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2];

                if (minSum2 > longTarget) {
                    break;
                }

                long maxSum2 = (long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2];

                if (maxSum2 < longTarget) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                long twoSumTarget = longTarget - nums[i] - nums[j];

                while (left < right) {
                    long currentSum = (long) nums[left] + nums[right];

                    if (currentSum == twoSumTarget) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        left++;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        right--;

                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (currentSum < twoSumTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}