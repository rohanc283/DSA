class Solution {
    public int lower_bound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        List<Long> res = new ArrayList<>();

        for (int query : queries) {
            int idx = lower_bound(nums, query);

            long leftCost = (long) query * idx - prefix[idx];
            long rightCost = (prefix[n] - prefix[idx])
                    - (long) query * (n - idx);

            res.add(leftCost + rightCost);
        }

        return res;
    }
}