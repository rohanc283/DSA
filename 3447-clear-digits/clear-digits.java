class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int i = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (i >= 0)
                    sb.deleteCharAt(i);
                i--;
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
}