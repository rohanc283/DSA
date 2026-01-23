class Solution {
    public String customSortString(String order, String s) {
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
}
