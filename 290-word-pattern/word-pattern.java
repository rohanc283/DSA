class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> mappedWords = new HashMap<>();
        Map<Character, String> mappedPattern = new HashMap<>();
        String[] words = s.split(" ");
        int patternLength = pattern.length();
        if (patternLength != words.length)
            return false;
        for (int i = 0; i < patternLength; i++) {
            if (mappedWords.containsKey(words[i]) && mappedWords.get(words[i]) != pattern.charAt(i))
                return false;
            if (mappedPattern.containsKey(pattern.charAt(i)) &&
                    !mappedPattern.get(pattern.charAt(i)).equals(words[i]))
                return false;
            mappedWords.put(words[i], pattern.charAt(i));
            mappedPattern.put(pattern.charAt(i), words[i]);
        }
        return true;
    }
}