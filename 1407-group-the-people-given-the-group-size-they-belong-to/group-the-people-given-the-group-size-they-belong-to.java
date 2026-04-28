class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>()).add(i);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (Integer key : map.keySet()) {
            List<Integer> nums = map.get(key);
            int n = nums.size();
            int idx = 0;
            while (idx < n) {
                res.add(nums.subList(idx, idx + key));
                idx += key;
            }
        }
        return res;
    }
}