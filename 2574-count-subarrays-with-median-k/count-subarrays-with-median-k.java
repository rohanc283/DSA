class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                idx = i;
                break;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = idx + 1; i < n; i++) {
            sum += (nums[i] > k ? 1 : -1);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        int res = 0;
        sum = 0;
        for (int i = idx; i >= 0; i--) {
            if (nums[i] != k) {
                sum += (nums[i] > k ? 1 : -1);
            }
            res += map.getOrDefault(-sum, 0);
            res += map.getOrDefault(1 - sum, 0);
        }
        return res;
    }
}