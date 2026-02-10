class Solution {
    public int subArraysWithAtleastK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0;
        int res = 0;
        for (int r = 0; r < n; r++) {
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
            while (freq.size() >= k) {
                res += (n - r);
                freq.put(nums[l], freq.get(nums[l]) - 1);
                if (freq.get(nums[l]) == 0)
                    freq.remove(nums[l]);
                l++;
            }
        }
        return res;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArraysWithAtleastK(nums, k) - subArraysWithAtleastK(nums, k + 1);
    }
}