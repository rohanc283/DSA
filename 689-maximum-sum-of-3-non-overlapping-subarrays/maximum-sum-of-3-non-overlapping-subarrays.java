class Solution {
    Integer[][] dp;

    private int helper(int[] subArr, int n, int k, int idx, int count) {
        if (count == 0)
            return 0;
        if (idx >= n)
            return Integer.MIN_VALUE;
        if (dp[idx][count] != null)
            return dp[idx][count];
        int take = subArr[idx] + helper(subArr, n, k, idx + k, count - 1);
        int skip = helper(subArr, n, k, idx + 1, count);
        return dp[idx][count] = Math.max(take, skip);
    }

    private void solve(int[] subArr, int n, int k, int idx, int count, List<Integer> res) {
        if (count <= 0)
            return;
        if (idx >= n)
            return;
        int startFromI = subArr[idx] + helper(subArr, n, k, idx + k, count - 1);
        int notStartFromI = helper(subArr, n, k, idx + 1, count);
        if (startFromI >= notStartFromI) {
            res.add(idx);
            solve(subArr, n, k, idx + k, count - 1, res);
        } else {
            solve(subArr, n, k, idx + 1, count, res);
        }
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] subArr = new int[n];
        int i = 0, j = 0, sum = 0;
        while (j < n) {
            sum += nums[j];
            while (j - i + 1 >= k) {
                subArr[i] = sum;
                sum -= nums[i];
                i++;
            }
            j++;
        }
        List<Integer> res = new ArrayList<>();
        dp = new Integer[n][4];
        solve(subArr, n, k, 0, 3, res);
        int[] ans = res.stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }
}