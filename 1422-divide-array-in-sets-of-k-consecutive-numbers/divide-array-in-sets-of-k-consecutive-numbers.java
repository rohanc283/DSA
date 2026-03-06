class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0)
            return false;

        Map<Integer, Integer> freq = new TreeMap<>();

        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        for (int key : freq.keySet()) {
            int count = freq.get(key);

            if (count > 0) {
                for (int i = 0; i < k; i++) {
                    int curr = key + i;

                    if (freq.getOrDefault(curr, 0) < count)
                        return false;

                    freq.put(curr, freq.get(curr) - count);
                }
            }
        }

        return true;
    }
}