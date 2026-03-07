class Solution {
    Set<Integer> deletedNums;

    // public int solve(int[] nums, int i, int n) {
    //     if (i >= n)
    //         return 0;
    //     int ans = 0;
    //     if (deletedNums.contains(nums[i])) {
    //         ans = solve(nums, i + 1, n);
    //     } else {
    //         int notDelete = solve(nums, i + 1, n);
    //         deletedNums.add(nums[i] - 1);
    //         deletedNums.add(nums[i] + 1);
    //         int delete = nums[i] + solve(nums, i + 1, n);
    //         deletedNums.remove(nums[i] - 1);
    //         deletedNums.remove(nums[i] + 1);
    //         ans = Math.max(delete, notDelete);
    //     }
    //     return ans;
    // }
    public int solveTab(int[] nums, int n) {
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);

        int[] sum = new int[max + 1];

        for (int num : nums)
            sum[num] += num;

        int prev1 = 0;
        int prev2 = 0;
        for (int i = 0; i <= max; i++) {
            int curr = Math.max(prev1, prev2 + sum[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.max(prev1, prev2);
    }

    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        // deletedNums = new HashSet<>();
        // return solve(nums, 0, n);
        return solveTab(nums, n);
    }
}