class Solution {
    public int sol1(int[] nums) {
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

    public int sol2(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }

    public int majorityElement(int[] nums) {
        return sol2(nums);
    }
}