class TextEditor {
    Deque<Character> left;
    Deque<Character> right;

    public TextEditor() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    public void addText(String text) {
        for (char c : text.toCharArray()) {
            left.push(c);
        }
    }

    public int deleteText(int k) {
        int deleted = 0;
        while (deleted < k && left.size() > 0) {
            left.pop();
            deleted++;
        }
        return deleted;
    }

    public String cursorLeft(int k) {
        while (k > 0 && left.size() > 0) {
            right.push(left.peek());
            left.pop();
            k--;
        }
        return getLast10();
    }

    public String cursorRight(int k) {
        while (k > 0 && right.size() > 0) {
            left.push(right.peek());
            right.pop();
            k--;
        }
        return getLast10();
    }

    private String getLast10() {
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        while (left.size() > 0 && cnt < 10) {
            res.append(left.peek());
            left.pop();
            cnt++;
        }

        res.reverse();

        for (int i = 0; i < res.length(); i++) {
            left.push(res.charAt(i));
        }
        return res.toString();
    }
}

// class TextEditor {
//     LinkedList<Character> chars;
//     int cursor = 0;

//     public TextEditor() {
//         chars = new LinkedList<>();
//     }

//     public void addText(String text) {
//         for (char c : text.toCharArray()) {
//             chars.add(cursor++, c);
//         }
//     }

//     public int deleteText(int k) {
//         int deleted = 0;
//         while (deleted < k && cursor > 0) {
//             chars.remove(--cursor);
//             deleted++;
//         }
//         return deleted;
//     }

//     public String cursorLeft(int k) {
//         cursor = Math.max(0, cursor - k);
//         return getLast10();
//     }

//     public String cursorRight(int k) {
//         cursor = Math.min(chars.size(), cursor + k);
//         return getLast10();
//     }

//     private String getLast10() {
//         StringBuilder res = new StringBuilder();
//         int start = Math.max(0, cursor - 10);

//         for (int i = start; i < cursor; i++) {
//             res.append(chars.get(i));
//         }
//         return res.toString();
//     }
// }

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */