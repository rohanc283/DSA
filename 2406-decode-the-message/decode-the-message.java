class Solution {
    public String decodeMessage(String key, String message) {
        char[] mapping = new char[26];
        boolean[] marked = new boolean[26];
        int i = 0;
        for (char c : key.toCharArray()) {
            if (c == ' ')
                continue;

            if (!marked[c - 'a']) {
                mapping[c - 'a'] = (char) (i + 'a');
                i++;
            }
            marked[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append(c == ' ' ? c : (char) mapping[c - 'a']);
        }
        return sb.toString();
    }
}