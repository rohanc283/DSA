class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                left[i] += 1 + left[i - 1];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                right[i] += 1 + right[i + 1];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            if (left[i - 1] >= k - 1 && right[i + 1] >= k - 1) {
                res.add(i);
            }
        }
        return res;
    }
}