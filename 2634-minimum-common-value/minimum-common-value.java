class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int s = 0, e = n - 1;
        for (int num : nums1) {
            int pos_in_nums2 = Arrays.binarySearch(nums2, num);
            if (pos_in_nums2 >= 0)
                return num;
        }
        return -1;
    }
}