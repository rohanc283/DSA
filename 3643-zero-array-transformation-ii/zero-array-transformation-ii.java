class Solution {
    public boolean allZeros(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0)
                return false;
        }
        return true;
    }

    public boolean isPossible(int[] nums, int n, int[][] queries, int k) {
        int[] diff = new int[n];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];
            diff[l] += x;
            if (r + 1 < n) {
                diff[r + 1] -= x;
            }
        }

        for (int j = 1; j < n; j++) {
            diff[j] += diff[j - 1];
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] - diff[j] > 0) {
                return false;
            }
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;
        if (allZeros(nums, n))
            return 0;

        int l = 1, r = q;
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isPossible(nums, n, queries, mid)) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}