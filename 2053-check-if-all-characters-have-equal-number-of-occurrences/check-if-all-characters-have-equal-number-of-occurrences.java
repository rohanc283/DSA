class Solution {
    public boolean areOccurrencesEqual(String s) {
        if (s.length() == 1)
            return true;
        Map<Character, Integer> letterMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            letterMap.put(c, letterMap.getOrDefault(c, 0) + 1);
        }
        int count = letterMap.get(s.charAt(0));
        for (Character key : letterMap.keySet()) {
            if (letterMap.get(key) != count)
                return false;
        }
        return true;
    }
}