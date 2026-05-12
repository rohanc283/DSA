class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int oddCount = 0;
        int res = 0;
        for (int num : nums) {
            oddCount += (num % 2 == 0 ? 0 : 1);
            int target = oddCount - k;
            res += map.getOrDefault(target, 0);
            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }
        return res;
    }
}