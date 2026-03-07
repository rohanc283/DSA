class Solution {
    private int sol1(String s) {
        int n = s.length();
        s = s + s;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                s1.append('0');
                s2.append('1');
            } else {
                s1.append('1');
                s2.append('0');
            }
        }

        int res = Integer.MAX_VALUE;
        int flip1 = 0, flip2 = 0;
        int i = 0, j = 0;

        while (j < 2 * n) {

            if (s.charAt(j) != s1.charAt(j))
                flip1++;
            if (s.charAt(j) != s2.charAt(j))
                flip2++;

            if (j - i + 1 > n) {
                if (s.charAt(i) != s1.charAt(i))
                    flip1--;
                if (s.charAt(i) != s2.charAt(i))
                    flip2--;
                i++;
            }

            if (j - i + 1 == n) {
                res = Math.min(res, Math.min(flip1, flip2));
            }

            j++;
        }

        return res;
    }

    private int sol2(String s) {
        int n = s.length();

        int res = Integer.MAX_VALUE;
        int flip1 = 0, flip2 = 0;

        int i = 0, j = 0;

        while (j < 2 * n) {

            char ch = s.charAt(j % n);

            char alt1 = (j % 2 == 0) ? '0' : '1';
            char alt2 = (j % 2 == 0) ? '1' : '0';

            if (ch != alt1)
                flip1++;
            if (ch != alt2)
                flip2++;

            if (j - i + 1 > n) {
                char left = s.charAt(i % n);

                char altLeft1 = (i % 2 == 0) ? '0' : '1';
                char altLeft2 = (i % 2 == 0) ? '1' : '0';

                if (left != altLeft1)
                    flip1--;
                if (left != altLeft2)
                    flip2--;

                i++;
            }

            if (j - i + 1 == n) {
                res = Math.min(res, Math.min(flip1, flip2));
            }

            j++;
        }

        return res;
    }

    public int minFlips(String s) {
        return sol2(s);
    }
}