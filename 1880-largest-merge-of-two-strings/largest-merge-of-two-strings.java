class Solution {

    public String largestMerge(String word1, String word2) {
        int i = 0, n1 = word1.length(), j = 0, n2 = word2.length();
        StringBuilder ans = new StringBuilder();
        while (i < n1 && j < n2) {
            if (word1.charAt(i) > word2.charAt(j)) {
                ans.append(word1.charAt(i++));
            } else if (word1.charAt(i) < word2.charAt(j)) {
                ans.append(word2.charAt(j++));
            } else {
                if (word1.substring(i, n1).compareTo(word2.substring(j, n2)) > 0) {
                    ans.append(word1.charAt(i++));
                } else {
                    ans.append(word2.charAt(j++));
                }
            }
        }
        while (i < n1) {
            ans.append(word1.charAt(i++));
        }
        while (j < n2) {
            ans.append(word2.charAt(j++));
        }
        return ans.toString();
    }
}