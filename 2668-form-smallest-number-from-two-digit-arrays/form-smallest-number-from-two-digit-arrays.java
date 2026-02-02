class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        boolean[] a = new boolean[10];
        boolean[] b = new boolean[10];

        for (int x : nums1)
            a[x] = true;
        for (int x : nums2)
            b[x] = true;

        int minA = -1, minB = -1;

        for (int i = 1; i <= 9; i++) {
            if (a[i] && b[i])
                return i;
            if (a[i] && minA == -1)
                minA = i;
            if (b[i] && minB == -1)
                minB = i;
        }

        return Math.min(minA * 10 + minB, minB * 10 + minA);
    }
}
