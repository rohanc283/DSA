class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> kn : knowledge) {
            map.put(kn.get(0), kn.get(1));
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(')
                res.append(c);
            else {
                StringBuilder curr = new StringBuilder();
                int j = i + 1;
                while (s.charAt(j) != ')') {
                    curr.append(s.charAt(j++));
                }
                String key = curr.toString();
                if (map.containsKey(key)) {
                    res.append(map.get(key));
                } else {
                    res.append("?");
                }
                i = j;
            }
        }
        return res.toString();
    }
}