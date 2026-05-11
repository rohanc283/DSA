class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int prefix = 0;
        map.put(0, 1);
        for (int num : nums) {
            prefix += num;
            int rem = ((prefix % k) + k) % k;
            count += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}