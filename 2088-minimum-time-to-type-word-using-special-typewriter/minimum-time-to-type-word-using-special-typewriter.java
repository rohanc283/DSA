class Solution {
    public int minTimeToType(String word) {
        int res = 0;
        char pointer = 'a';
        for (char c : word.toCharArray()) {
            int a = (c - pointer + 26) % 26;
            int b = (pointer - c + 26) % 26;
            int diff = Math.min(a, b);
            System.out.println(diff);
            res = res + diff + 1;
            pointer = c;
        }
        return res;
    }
}