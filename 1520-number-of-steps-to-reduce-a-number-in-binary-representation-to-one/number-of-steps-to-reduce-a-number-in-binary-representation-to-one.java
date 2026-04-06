class Solution {
    public String addBinary(String a, String b) {
        char[] digits1 = a.toCharArray();
        char[] digits2 = b.toCharArray();
        int n1 = digits1.length, n2 = digits2.length;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        int i = n1 - 1, j = n2 - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int d1 = i < 0 ? 0 : digits1[i--] - '0';
            int d2 = j < 0 ? 0 : digits2[j--] - '0';
            int d = carry ^ d1 ^ d2;
            carry = (carry & (d1 ^ d2)) >= 1 || (d1 & d2) >= 1 ? 1 : 0;
            res.append((char) (d + '0'));
        }
        return res.reverse().toString();
    }

    private int sol1(String s) {
        int n = s.length();
        if (n == 1)
            return 0;
        char last = s.charAt(n - 1);
        if (last == '0') {
            return 1 + sol1(s.substring(0, n - 1));
        } else {
            return 1 + sol1(addBinary(s, "1"));
        }
    }

    private int sol2(String s) {
        int n = s.length();
        int op = 0, carry = 0;
        for (int i = n - 1; i > 0; i--) {
            int d = (s.charAt(i) - '0') + carry;
            if (d == 1) {
                op += 2;
                carry = 1;
            } else {
                op += 1;
            }
        }
        return op + carry;
    }

    public int numSteps(String s) {
        return sol2(s);
    }
}