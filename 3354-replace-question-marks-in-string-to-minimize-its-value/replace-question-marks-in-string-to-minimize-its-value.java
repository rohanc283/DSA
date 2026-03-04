class Solution {
    public String minimizeStringValue(String s) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            if (c != '?') {
                freq[c - 'a']++;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> freq[a] == freq[b] ? a - b : freq[a] - freq[b]);

        for (int i = 0; i < 26; i++) {
            pq.offer(i);
        }

        List<Character> replacements = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c == '?') {
                int ch = pq.poll();
                replacements.add((char) (ch + 'a'));
                freq[ch]++;
                pq.offer(ch);
            }
        }

        Collections.sort(replacements);

        StringBuilder res = new StringBuilder();
        int idx = 0;

        for (char c : s.toCharArray()) {
            if (c == '?') {
                res.append(replacements.get(idx++));
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}