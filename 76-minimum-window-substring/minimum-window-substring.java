class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        Map<Character, Integer> freq = new HashMap<>();
        int rem = 0;
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            rem++;
        }
        int n = s.length();
        int start = 0, end = 0;
        int resStartIdx = -1, resEndIdx = -1;
        while (end < n) {
            char c1 = s.charAt(end);
            if (freq.getOrDefault(c1, 0) > 0)
                rem--;
            freq.put(c1, freq.getOrDefault(c1, 0) - 1);

            while (rem == 0) {
                int currLength = end - start + 1;
                int prevLength = resEndIdx - resStartIdx + 1;
                if ((resEndIdx == -1 && resStartIdx == -1) || currLength < prevLength) {
                    resStartIdx = start;
                    resEndIdx = end;
                }
                char c2 = s.charAt(start);
                freq.put(c2, freq.getOrDefault(c2, 0) + 1);
                if (freq.getOrDefault(c2, 0) > 0)
                    rem++;
                start++;
            }
            end++;
        }
        if (resStartIdx == -1 && resEndIdx == -1)
            return "";
        return s.substring(resStartIdx, resEndIdx + 1);
    }
}