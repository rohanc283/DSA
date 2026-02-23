class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();
        int n = nums.size();
        int res = Integer.MAX_VALUE;

        for (int i = x; i < n; i++) {
            set.add(nums.get(i - x));
            int val = nums.get(i);
            Integer ceil = set.ceiling(val);
            if (ceil != null) {
                res = Math.min(res, Math.abs(ceil - val));
            }
            Integer floor = set.floor(val);
            if (floor != null) {
                res = Math.min(res, Math.abs(floor - val));
            }
        }
        return res;
    }
}