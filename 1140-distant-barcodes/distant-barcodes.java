class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxiVal = 0, maxiFreq = 0;
        for (int i = 0; i < n; i++) {
            map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
            if (map.get(barcodes[i]) > maxiFreq) {
                maxiFreq = map.get(barcodes[i]);
                maxiVal = barcodes[i];
            }
        }
        int i = 0;
        while (map.containsKey(maxiVal) && map.get(maxiVal) > 0) {
            barcodes[i] = maxiVal;
            map.put(maxiVal, map.get(maxiVal) - 1);
            if (map.get(maxiVal) == 0)
                map.remove(maxiVal);
            i += 2;
        }

        for (Integer key : map.keySet()) {
            int val = map.get(key);
            while (val > 0) {
                if (i >= n)
                    i = 1;
                barcodes[i] = key;
                val--;
                i += 2;
            }
        }

        return barcodes;
    }
}