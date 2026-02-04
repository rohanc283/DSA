class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            StringBuilder curr = new StringBuilder();
            int j = i;
            while (j < word.length() && j < i + k) {
                curr.append(word.charAt(j++));
            }
            String key = curr.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            j--;
            i = j;
        }

        String sr = "";
        int occ = 0;
        for (String key : map.keySet()) {
            int val = map.get(key);
            if (occ == 0) {
                occ = val;
                sr = key;
            } else {
                if (val > occ) {
                    occ = val;
                    sr = key;
                }
            }

        }
        System.out.println(sr);
        int count = 0;
        for (int i = 0; i < word.length(); i += k) {
            if (!word.substring(i, i + k).equals(sr))
                count++;
        }
        return count;
    }
}