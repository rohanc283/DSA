class Solution {
    public int maxDepth(String s) {
        int res = 0, curr = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                curr++;
                res = Math.max(res, curr);
            } else if (c == ')') {
                curr--;
            }
        }
        return res;
    }
}