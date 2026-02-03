class Solution {
    public String entityParser(String text) {
        Map<String, String> map = Map.of(
                "&quot;", "\"",
                "&apos;", "'",
                "&amp;", "&",
                "&gt;", ">",
                "&lt;", "<",
                "&frasl;", "/");

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            boolean matched = false;

            if (text.charAt(i) == '&') {
                for (String entity : map.keySet()) {
                    if (text.startsWith(entity, i)) {
                        res.append(map.get(entity));
                        i += entity.length() - 1;
                        matched = true;
                        break;
                    }
                }
            }

            if (!matched) {
                res.append(text.charAt(i));
            }
        }

        return res.toString();
    }
}
