class Solution {
    public int maxDepth(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int res = 0, curr = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                deque.addLast(c);
                curr++;
                res = Math.max(res, curr);
            } else if (c == ')') {
                if (deque.isEmpty())
                    break;
                deque.removeLast();
                curr--;
            }
        }
        return res;
    }
}