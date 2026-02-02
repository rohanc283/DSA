class Solution {
    public List<String> commonChars(String[] words) {
        StringBuilder sb1 = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++) {
            StringBuilder sb2 = new StringBuilder(words[i]);
            for (int j = 0; j < sb1.length(); j++) {
                int k = sb2.indexOf(String.valueOf(sb1.charAt(j)));
                if (k != -1) {
                    sb2.deleteCharAt(k);
                } else {
                    sb1.deleteCharAt(j);
                    j--;
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < sb1.length(); i++) {
            res.add(String.valueOf(sb1.charAt(i)));
        }
        return res;
    }
}