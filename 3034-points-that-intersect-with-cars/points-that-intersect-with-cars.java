class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Collections.sort(nums, (a, b) -> {
            int startComp = Integer.compare(a.get(0), b.get(0));
            if (startComp != 0) {
                return startComp;
            }
            return Integer.compare(a.get(1), b.get(1));
        });
        int ans = 0;
        int s = nums.get(0).get(0), e = nums.get(0).get(1);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i).get(0) <= e) {
                e = Math.max(e, nums.get(i).get(1));
            } else {
                ans += (e - s + 1);
                s = nums.get(i).get(0);
                e = nums.get(i).get(1);
            }
        }
        ans += (e - s + 1);
        return ans;
    }
}