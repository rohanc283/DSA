class Solution {
    public double sol1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int t = m + n;
        int[] temp = new int[t];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }

        while (i < m) {
            temp[k++] = nums1[i++];
        }

        while (j < n) {
            temp[k++] = nums2[j++];
        }

        if (t % 2 != 0) {
            return temp[t / 2];
        }

        return (temp[t / 2] + temp[(t / 2) - 1]) / 2.0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return sol1(nums1, nums2);
    }
}