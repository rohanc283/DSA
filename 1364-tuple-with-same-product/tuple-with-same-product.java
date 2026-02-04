class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] * nums[j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int tuples = 0;
        for (Integer value : map.values()) {
            tuples += ((value * (value - 1)) / 2);
        }
        return tuples * 8;
    }
}