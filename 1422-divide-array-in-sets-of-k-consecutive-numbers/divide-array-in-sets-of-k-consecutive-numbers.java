class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new TreeMap<>();

        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        for (Integer key : freq.keySet()) {
            int keyFreq = freq.get(key);
            if (keyFreq == 0)
                continue;
            while (keyFreq-- > 0) {
                for (int curr = key; curr < key + k; curr++) {
                    if (!freq.containsKey(curr) || freq.get(curr) == 0)
                        return false;
                    freq.put(curr, freq.get(curr) - 1);
                }
            }
        }
        return true;
    }
}