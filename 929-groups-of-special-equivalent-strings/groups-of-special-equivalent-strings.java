class Solution {
    public String sorted(String odd) {
        char[] c = odd.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }

    public int numSpecialEquivGroups(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    odd.append(word.charAt(i));
                } else {
                    even.append(word.charAt(i));
                }
            }
            set.add(sorted(odd.toString()) + sorted(even.toString()));
        }
        return set.size();
    }
}