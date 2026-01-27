class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Map<Integer, Integer> diff = new TreeMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int l = Math.max(0, num - k);
            int r = num + k + 1;
            diff.put(l, diff.getOrDefault(l, 0) + 1);
            diff.put(r, diff.getOrDefault(r, 0) - 1);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (diff.containsKey(nums[i])) {
                continue;
            }
            diff.put(nums[i], 0);
        }

        int res = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            int target = entry.getKey();
            sum += entry.getValue();
            diff.put(target, sum);

            int targetCount = freq.getOrDefault(target, 0);
            int needConversion = sum - targetCount;
            int maxPosFreq = targetCount + Math.min(numOperations, needConversion);
            res = Math.max(res, maxPosFreq);
        }
        return res;
    }
}