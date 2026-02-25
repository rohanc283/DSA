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

    public double sol2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int t = m + n;
        int idx1 = t / 2, idx2 = (t / 2) - 1;
        int element1 = -1, element2 = -1;

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                if (k == idx1) {
                    element1 = nums1[i];
                }
                if (k == idx2) {
                    element2 = nums1[i];
                }
                i++;
                k++;
            } else {
                if (k == idx1) {
                    element1 = nums2[j];
                }
                if (k == idx2) {
                    element2 = nums2[j];
                }
                j++;
                k++;
            }
        }

        while (i < m) {
            if (k == idx1) {
                element1 = nums1[i];
            }
            if (k == idx2) {
                element2 = nums1[i];
            }
            i++;
            k++;
        }

        while (j < n) {
            if (k == idx1) {
                element1 = nums2[j];
            }
            if (k == idx2) {
                element2 = nums2[j];
            }
            j++;
            k++;
        }

        if (t % 2 != 0) {
            return element1;
        }

        return (element1 + element2) / 2.0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return sol2(nums1, nums2);
    }
}