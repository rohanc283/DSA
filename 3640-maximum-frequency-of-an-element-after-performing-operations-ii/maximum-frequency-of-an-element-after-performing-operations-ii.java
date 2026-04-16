class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> diff = new TreeMap<>();
        for (int num : nums) {
            int l = Math.max(num - k, 0);
            int r = num + k + 1;

            diff.put(l, diff.getOrDefault(l, 0) + 1);
            diff.put(r, diff.getOrDefault(r, 0) - 1);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (diff.containsKey(num))
                continue;
            diff.put(num, 0);
        }
        int maxFreq = 0;
        int prefix = 0;
        for (Integer target : diff.keySet()) {
            prefix += diff.get(target);
            int targetCount = freq.getOrDefault(target, 0);
            maxFreq = Math.max(maxFreq, targetCount + Math.min(prefix - targetCount, numOperations));
        }
        return maxFreq;
    }
}