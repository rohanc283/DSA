class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> res = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) > (n / 3)) {
                res.add(key);
            }
        }

        return res;
    }
}