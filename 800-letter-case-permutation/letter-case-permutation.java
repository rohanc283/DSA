class Solution {
    private void helper(char[] s, int i, List<String> res) {
        int n = s.length;
        if (i >= n) {
            res.add(new String(s));
            return;
        }
        char c = s[i];
        helper(s, i + 1, res);
        if (Character.isLowerCase(c)) {
            s[i] = (char) (c - 32);
            helper(s, i + 1, res);
            s[i] = c;
        } else if (Character.isUpperCase(c)) {
            s[i] = (char) (c + 32);
            helper(s, i + 1, res);
            s[i] = c;
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        helper(s.toCharArray(), 0, res);
        return res;
    }
}