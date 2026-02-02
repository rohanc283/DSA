class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] num1Digit = new int[10];
        int[] num2Digit = new int[10];

        for (int i = 0; i < nums1.length; i++) {
            num1Digit[nums1[i]]++;
        }

        for (int i = 0; i < nums2.length; i++) {
            num2Digit[nums2[i]]++;
        }

        int res = 0;
        int num1 = -1, num2 = -1;
        for (int i = 1; i < 10; i++) {
            if (num1Digit[i] > 0 && num2Digit[i] > 0)
                return i;
            if (num1Digit[i] > 0 && num1 == -1)
                num1 = i;
            if (num2Digit[i] > 0 && num2 == -1)
                num2 = i;

        }

        if (num1 < num2)
            return num1 * 10 + num2;
        return num2 * 10 + num1;
    }
}