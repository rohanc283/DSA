class Solution {
    public int maxVowels(String s, int k) {
        int res = 0, vowels = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char cj = s.charAt(j);
            if ("aeiou".indexOf(cj) != -1)
                vowels++;
            if (j >= k - 1) {
                res = Math.max(res, vowels);
                char ci = s.charAt(i++);
                if ("aeiou".indexOf(ci) != -1)
                    vowels--;
            }
        }
        return res;
    }
}