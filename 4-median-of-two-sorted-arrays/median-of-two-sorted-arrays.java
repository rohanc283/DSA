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

    public double sol3(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return sol3(nums2, nums1);
        }
        int t = m + n;
        int p = (t + 1) / 2;
        int l = 0, h = m;
        while (l <= h) {
            int px = l + (h - l) / 2; // from nums1
            int py = p - px; // from nums2
            int x1 = px > 0 ? nums1[px - 1] : Integer.MIN_VALUE;
            int x2 = py > 0 ? nums2[py - 1] : Integer.MIN_VALUE;
            int x3 = px < m ? nums1[px] : Integer.MAX_VALUE;
            int x4 = py < n ? nums2[py] : Integer.MIN_VALUE;
            if (x1 <= x4 && x2 <= x3) {
                if (t % 2 != 0) {
                    return Math.max(x1, x2);
                }
                return (Math.max(x1, x2) + Math.min(x3, x4)) / 2.0;
            } else if (x1 > x4) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return sol2(nums1, nums2);
    }
}