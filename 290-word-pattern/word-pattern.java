class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strList = s.split(" ");
        if (pattern.length() != strList.length)
            return false;
        Map<Character, String> patternToStrMapping = new HashMap<>();
        Map<String, Character> strToPatternMapping = new HashMap<>();
        for (int i = 0; i < strList.length; i++) {
            char c = pattern.charAt(i);
            String str = strList[i];
            if (patternToStrMapping.containsKey(c) && !patternToStrMapping.get(c).equals(str))
                return false;
            if (strToPatternMapping.containsKey(str) && strToPatternMapping.get(str) != c)
                return false;
            patternToStrMapping.put(c, str);
            strToPatternMapping.put(str, c);
        }
        return true;
    }
}