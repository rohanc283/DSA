class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0) {
                    res.append(c);
                }
                depth++;
            } else {
                if (depth > 1) {
                    res.append(c);
                }
                depth--;
            }
        }
        return res.toString();
    }
}