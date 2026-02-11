class Solution {
    public int minInsertions(String s) {
        int open = 0, insertion = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    insertion++;
                }

                if (open > 0)
                    open--;
                else
                    insertion++;
            }
        }
        insertion += 2 * open;
        return insertion;
    }
}