class Solution {
    public String makeLargestSpecial(String s) {
        List<String> strings = new ArrayList<>();

        int start = 0, sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) == '1' ? 1 : -1;
            if (sum == 0) {
                String inner = s.substring(start + 1, i);
                strings.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }
        Collections.sort(strings, (a, b) -> b.compareTo(a));
        StringBuilder res = new StringBuilder();
        for (String str : strings)
            res.append(str);
        return res.toString();
    }
}