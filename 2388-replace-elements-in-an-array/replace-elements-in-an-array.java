class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < operations.length; i++) {
            int prev = operations[i][0];
            int curr = operations[i][1];
            map.put(curr, map.get(prev));
            map.remove(prev);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums[entry.getValue()] = entry.getKey();
        }
        return nums;
    }
}