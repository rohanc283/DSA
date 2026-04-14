class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int j = s.length();
        for (int i = j - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && j == i + 1) {
                j--;
                continue;
            } else if (s.charAt(i) == ' ') {
                if (res.length() > 0)
                    res.append(' ');
                res.append(s.substring(i + 1, j));
                j = i;
            } else if (i == 0 && s.charAt(i) != ' ') {
                if (res.length() > 0)
                    res.append(' ');
                res.append(s.substring(i, j));
            }
        }
        return res.toString();
    }
}