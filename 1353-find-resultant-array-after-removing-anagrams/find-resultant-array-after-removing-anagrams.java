class Solution {

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int f : freq)
            if (f != 0)
                return false;

        return true;
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!isAnagram(words[i], res.get(res.size() - 1))) {
                res.add(words[i]);
            }
        }
        return res;
    }
}
