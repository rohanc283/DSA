class Solution {
    public int countSubarrays(int[] nums, int k) {

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                idx = i;
                break;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);

        for (int i = idx + 1; i < nums.length; i++) {
            sum += nums[i] > k ? 1 : -1;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        int ans = 0;
        sum = 0;

        for (int i = idx; i >= 0; i--) {
            if (nums[i] != k)
                sum += nums[i] > k ? 1 : -1;

            ans += map.getOrDefault(-sum, 0);
            ans += map.getOrDefault(1 - sum, 0);
        }

        return ans;
    }
}