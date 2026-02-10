class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,  Integer>freq = new HashMap<>();
        int n = s.length();
        int i = 0, j = 0;
        int res = 0;
        while(j < n){
            char c = s.charAt(j);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while(i < j && freq.get(c) > 1){
                char c2 = s.charAt(i++);
                freq.put(c2, freq.get(c2) - 1);
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}