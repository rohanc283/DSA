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
}