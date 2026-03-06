class Solution {
    public String smallestString(String s) {
        char[] arr = s.toCharArray();
        int i = 0;

        while (i < arr.length && arr[i] == 'a') {
            i++;
        }

        if (i == arr.length) {
            arr[arr.length - 1] = 'z';
            return new String(arr);
        }

        while (i < arr.length && arr[i] != 'a') {
            arr[i]--;
            i++;
        }

        return new String(arr);
    }
}