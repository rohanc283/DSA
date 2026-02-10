class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, s = 0, e = 0;
        int res = 0, curr = 1, size = 0;
        while (e < n) {
            curr *= nums[e];
            while (curr >= k && s <= e) {
                curr /= nums[s++];
                size--;
            }
            size++;
            res += size;
            e++;
        }
        return res;
    }
}