class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0, n1 = str1.length(), n2 = str2.length();
        while (i < n1 && j < n2) {
            if (str1.charAt(i) != str2.charAt(j)) {
                if (str1.charAt(i) == 'z' && str2.charAt(j) == 'a') {
                    i++;
                    j++;
                } else if ((char) (str1.charAt(i) + 1) == str2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            } else {
                i++;
                j++;
            }
        }
        return j < n2 ? false : true;
    }
}