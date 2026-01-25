class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        int n1 = str1.length(), n2 = str2.length();

        while (i < n1 && j < n2) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);

            char next = (char) ((c1 - 'a' + 1) % 26 + 'a');

            if (c1 == c2 || next == c2) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == n2;
    }
}
