class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                deque.addLast(c);
            } else {
                if (deque.isEmpty())
                    return false;
                if (c == ')' && deque.peekLast() == '(') {
                    deque.removeLast();
                } else if (c == '}' && deque.peekLast() == '{') {
                    deque.removeLast();
                } else if (c == ']' && deque.peekLast() == '[') {
                    deque.removeLast();
                } else {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}