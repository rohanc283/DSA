class Solution {
    public String sol1(String order, String s) {
        int[] priorityList = new int[27];
        Arrays.fill(priorityList, Integer.MAX_VALUE);

        int priority = 1;
        for (int i = 0; i < order.length(); i++) {
            int idx = order.charAt(i) - 'a';
            priorityList[idx] = priority++;
        }

        Character[] chars = s.chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);

        Arrays.sort(chars, (a, b) -> priorityList[a - 'a'] - priorityList[b - 'a']);

        StringBuilder sb = new StringBuilder();
        for (char c : chars)
            sb.append(c);

        return sb.toString();
    }

    public static String sol2(String order, String s) {
        int[] freq = new int[27];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            int idx = order.charAt(i) - 'a';
            while (freq[idx] > 0) {
                sb.append(order.charAt(i));
                freq[idx]--;
            }
        }

        for (int i = 0; i < 27; i++) {
            while (freq[i] > 0) {
                char c = (char) ('a' + i);
                sb.append(c);
                freq[i]--;
            }
        }
        return sb.toString();
    }

    public String customSortString(String order, String s) {
        return sol2(order, s);
    }
}
