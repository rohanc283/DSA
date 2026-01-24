class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] temp = new int[n1 + n2][2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (nums1[i][0] < nums2[j][0]) {
                temp[k][0] = nums1[i][0];
                temp[k][1] = nums1[i][1];
                i++;
            } else if (nums1[i][0] > nums2[j][0]) {
                temp[k][0] = nums2[j][0];
                temp[k][1] = nums2[j][1];
                j++;
            } else {
                temp[k][0] = nums1[i][0];
                temp[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            }
            k++;
        }

        while (i < n1) {
            temp[k][0] = nums1[i][0];
            temp[k][1] = nums1[i][1];
            i++;
            k++;
        }

        while (j < n2) {
            temp[k][0] = nums2[j][0];
            temp[k][1] = nums2[j][1];
            j++;
            k++;
        }

        return Arrays.copyOf(temp, k);
    }
}
