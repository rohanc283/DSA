class Solution {
    public String entityParser(String text) {
        Map<String, String> map = Map.of(
                "&gt;", ">",
                "&lt;", "<",
                "&amp;", "&",
                "&quot;", "\"",
                "&apos;", "'",
                "&frasl;", "/");

        StringBuilder res = new StringBuilder();
        int n = text.length();
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (c == '&') {
                String key = text.substring(i, Math.min(n, i + 4));
                String key2 = text.substring(i, Math.min(n, i + 5));
                String key3 = text.substring(i, Math.min(n, i + 6));
                String key4 = text.substring(i, Math.min(n, i + 7));
                if (map.containsKey(key)) {
                    res.append(map.get(key));
                    i += 3;
                    continue;
                } else if (map.containsKey(key2)) {
                    res.append(map.get(key2));
                    i += 4;
                    continue;
                } else if (map.containsKey(key3)) {
                    res.append(map.get(key3));
                    i += 5;
                    continue;
                } else if (map.containsKey(key4)) {
                    res.append(map.get(key4));
                    i += 6;
                    continue;
                } else {
                    res.append(c);
                }
            } else {
                res.append(c);
            }
        }
        return res.toString();

    }
}