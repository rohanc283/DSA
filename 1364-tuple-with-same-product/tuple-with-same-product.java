class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long num1 = 1L * nums[i], num2 = 1L * nums[j];
                long prodNum = num1 * num2;
                if (map.containsKey(prodNum)) {
                    res += (8 * map.get(prodNum));
                }
                map.put(prodNum, map.getOrDefault(prodNum, 0) + 1);
            }
        }
        return res;
    }
}