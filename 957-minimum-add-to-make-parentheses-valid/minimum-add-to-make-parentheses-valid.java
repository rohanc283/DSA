class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                deque.addLast(c);
            } else {
                if (!deque.isEmpty() && deque.peekLast() == '(') {
                    deque.removeLast();
                } else {
                    deque.addLast(c);
                }
            }
        }
        return deque.size();
    }
}