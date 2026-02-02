class Solution {
    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        boolean[] seen = new boolean[26];
        int idx = 0;

        for (char c : key.toCharArray()) {
            if (c == ' ')
                continue;
            if (!seen[c - 'a']) {
                map[c - 'a'] = (char) (idx++ + 'a');
                seen[c - 'a'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append(c == ' ' ? ' ' : map[c - 'a']);
        }
        return sb.toString();
    }
}
