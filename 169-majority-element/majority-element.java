class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (Integer key : map.keySet()) {
            if (map.get(key) > (n / 2))
                return key;
        }

        return -1;
    }
}