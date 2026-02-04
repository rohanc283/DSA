class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int i = 0, j = 0;
        int partition = 1;
        while (i < nums.length) {
            if (i > j) {
                partition = (partition * 2) % 1_000_000_007;
            }
            j = Math.max(j, map.get(nums[i]));
            i++;
        }
        return partition;
    }
}