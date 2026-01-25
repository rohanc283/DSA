class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, n1 = word1.length(), j = 0, n2 = word2.length();
        StringBuilder ans = new StringBuilder();
        while (i < n1 || j < n2) {
            if (i < n1 && j >= n2) {
                ans.append(word1.charAt(i++));
            } else if (i >= n1 && j < n2) {
                ans.append(word2.charAt(j++));
            } else if (i == j) {
                ans.append(word1.charAt(i++));
            } else {
                ans.append(word2.charAt(j++));
            }
        }
        return ans.toString();
    }
}