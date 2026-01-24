class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i - k; j <= i + k; j++) {
                if (j >= 0 && j < n && nums[j] == key) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}