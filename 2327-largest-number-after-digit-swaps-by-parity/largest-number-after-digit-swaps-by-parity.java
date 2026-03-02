class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> evenMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> oddMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder numStr = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < numStr.length(); i++) {
            Integer val = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            if (val % 2 == 0) {
                evenMaxHeap.offer(val);
            } else {
                oddMaxHeap.offer(val);
            }
        }
        for (int i = 0; i < numStr.length(); i++) {
            Integer val = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            if (val % 2 == 0) {
                numStr.setCharAt(i, (char) (evenMaxHeap.poll() + '0'));
            } else {
                numStr.setCharAt(i, (char) (oddMaxHeap.poll() + '0'));
            }
        }
        return Integer.parseInt(numStr.toString());
    }
}