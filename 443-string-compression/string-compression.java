class Solution {
    public int compress(char[] chars) {
        int count = 1;
        int lastIndex = 0;

        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
            } else {
                chars[lastIndex++] = chars[i];

                if (count > 1) {
                    String s = String.valueOf(count);
                    for (int j = 0; j < s.length(); j++) {
                        chars[lastIndex++] = s.charAt(j);
                    }
                    count = 1;
                }
            }
        }
        return lastIndex;
    }
}
