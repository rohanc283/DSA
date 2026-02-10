class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int s = 0, e = 0;
        int res = 0;
        while (e < n) {
            map.put(nums[e], map.getOrDefault(nums[e], 0) + 1);
            while (!map.isEmpty() && map.lastKey() - map.firstKey() > limit) {
                map.put(nums[s], map.get(nums[s]) - 1);
                if (map.get(nums[s]) == 0)
                    map.remove(nums[s]);
                s++;
            }
            res = Math.max(res, e - s + 1);
            e++;
        }
        return res;
    }
}