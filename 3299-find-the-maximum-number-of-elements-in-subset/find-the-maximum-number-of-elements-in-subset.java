class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(1L * num, map.getOrDefault(1L * num, 0) + 1);
        }
        int res = 1;
        for (Long key : map.keySet()) {
            if (key == 1) {
                int f = map.get(key);
                res = Math.max(res, f % 2 == 0 ? f - 1 : f);
                continue;
            }
            int count = 1;
            long curr = key;
            while (map.containsKey(curr * curr) && map.get(curr) >= 2) {
                count += 2;
                curr *= curr;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}