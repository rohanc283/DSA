class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (sToT.containsKey(cs) && sToT.get(cs) != ct)
                return false;
            if (tToS.containsKey(ct) && tToS.get(ct) != cs)
                return false;

            sToT.put(cs, ct);
            tToS.put(ct, cs);
        }
        return true;
    }
}
