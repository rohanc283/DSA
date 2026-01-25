class Solution {
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        return false;
    }

    public String reverseVowels(String str) {
        StringBuilder sb = new StringBuilder(str);
        int s = 0, e = str.length() - 1;
        while (s < e) {
            char sc = sb.charAt(s);
            if (!isVowel(sc)) {
                s++;
                continue;
            }
            char ec = sb.charAt(e);
            if (!isVowel(ec)) {
                e--;
                continue;
            }
            char c = sb.charAt(s);
            sb.setCharAt(s++, sb.charAt(e));
            sb.setCharAt(e--, c);
        }
        return sb.toString();
    }
}