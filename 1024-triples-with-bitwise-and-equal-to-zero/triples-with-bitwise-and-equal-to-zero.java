class Solution {
    public int countTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = nums[i] & nums[j];
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
        }
        int count = 0;
        for (Integer i : map.keySet()) {
            for (int num : nums) {
                if ((i & num) == 0)
                    count += map.get(i);
            }
        }
        return count;
    }
}