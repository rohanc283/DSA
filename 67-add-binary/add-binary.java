class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int d1 = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int d2 = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sumBit = d1 ^ d2 ^ carry;
            sb.append(sumBit);

            carry = (d1 & d2) | (carry & (d1 ^ d2));
        }

        return sb.reverse().toString();
    }
}
