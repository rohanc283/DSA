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

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        map.computeIfAbsent(strs[0], k -> new ArrayList<>());

        for (int i = 1; i < strs.length; i++) {
            boolean foundAnagram = false;

            for (String key : map.keySet()) {
                if (isAnagram(strs[i], key)) {
                    map.get(key).add(strs[i]);
                    foundAnagram = true;
                    break;
                }
            }

            if (!foundAnagram) {
                map.computeIfAbsent(strs[i], k -> new ArrayList<>());
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (String key : map.keySet()) {
            List<String> curr = new ArrayList<>();
            curr.add(key);

            List<String> values = map.getOrDefault(key, new ArrayList<>());

            for (String val : values) {
                curr.add(val);
            }

            res.add(curr);
        }

        return res;
    }
}
