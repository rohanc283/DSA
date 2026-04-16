class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxi = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxi = Math.max(maxi, num);
        }

        int[] diff = new int[maxi + 1];
        for (int num : nums) {
            int left = Math.max(0, num - k), right = Math.min(maxi, num + k);
            diff[left]++;
            if (right < maxi) {
                diff[right + 1]--;
            }
        }
        for (int i = 1; i <= maxi; i++) {
            diff[i] += diff[i - 1];
        }
        int maxFreq = 0;
        for (int target = 0; target <= maxi; target++) {
            int f = map.getOrDefault(target, 0);
            maxFreq = Math.max(maxFreq, f + Math.min(diff[target] - f, numOperations));
        }
        return maxFreq;
    }
}