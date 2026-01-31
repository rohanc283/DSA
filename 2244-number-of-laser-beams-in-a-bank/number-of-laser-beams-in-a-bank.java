class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int[] rowSecDevices = new int[n];
        for (int i = 0; i < n; i++) {
            int secDeviceCount = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1')
                    secDeviceCount++;
            }
            rowSecDevices[i] = secDeviceCount;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && rowSecDevices[j] == 0)
                j++;
            if (j != n)
                count += rowSecDevices[i] * rowSecDevices[j];
        }
        return count;
    }
}