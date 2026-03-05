import java.util.*;

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);

        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums2[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int left = 0;
        int right = n - 1;

        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            int num = arr[i][0];
            int idx = arr[i][1];

            if (nums1[right] > num) {
                res[idx] = nums1[right];
                right--;
            } else {
                res[idx] = nums1[left];
                left++;
            }
        }

        return res;
    }
}