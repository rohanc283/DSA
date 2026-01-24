class Solution {
    private void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void reverse(char[] a, int l, int r) {
        while (l < r)
            swap(a, l++, r--);
    }

    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int len = digits.length;

        int i = len - 2;
        while (i >= 0 && digits[i] >= digits[i + 1])
            i--;
        if (i < 0)
            return -1;

        int j = len - 1;
        while (digits[j] <= digits[i])
            j--;
        swap(digits, i, j);

        reverse(digits, i + 1, len - 1);

        long ans = 0;
        for (char c : digits) {
            ans = ans * 10 + (c - '0');
            if (ans > Integer.MAX_VALUE)
                return -1;
        }
        return (int) ans;
    }
}
