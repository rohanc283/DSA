class Solution {
    public boolean isAnagram(String s, String t) {
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
        for (String word : words)
            res.add(word);
        while (res.size() > 1) {
            int i = 1;
            while (i < res.size()) {
                if (isAnagram(res.get(i), res.get(i - 1))) {
                    res.remove(i);
                    break;
                }
                i++;
            }
            if (i == res.size())
                break;
        }
        return res;
    }
}