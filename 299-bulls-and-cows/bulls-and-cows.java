class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i), b = guess.charAt(i);
            if (a == b) {
                bulls++;
                continue;
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (int i = 0; i < guess.length(); i++) {
            char a = secret.charAt(i), b = guess.charAt(i);
            if (a != b) {
                if (map.containsKey(b)) {
                    int v = map.get(b);
                    cows++;
                    if (v - 1 == 0) {
                        map.remove(b);
                    } else {
                        map.put(b, v - 1);
                    }
                }
            }
        }
        String res = bulls + "A" + cows + "B";
        return res;
    }
}