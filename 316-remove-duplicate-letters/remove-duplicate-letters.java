class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] seen = new boolean[26];
        int[] lastIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastIdx[c - 'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c - 'a'])
                continue;
            while (!stack.isEmpty() && c <= stack.peek() && lastIdx[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            seen[c - 'a'] = true;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.append(stack.pop());
        return res.reverse().toString();
    }
}