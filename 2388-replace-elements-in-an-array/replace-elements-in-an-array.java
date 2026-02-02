class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int[] op : operations) {
            int prev = op[0], curr = op[1];
            int idx = map.remove(prev);
            nums[idx] = curr;
            map.put(curr, idx);
        }
        return nums;
    }
}
