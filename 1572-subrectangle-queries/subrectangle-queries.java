class SubrectangleQueries {
    int[][] matrix;
    List<List<Integer>> updates;

    public SubrectangleQueries(int[][] rectangle) {
        matrix = rectangle;
        updates = new ArrayList<>();
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        updates.add(Arrays.asList(row1, col1, row2, col2, newValue));
    }

    public int getValue(int row, int col) {
        int value = matrix[row][col];
        for (List<Integer> update : updates) {
            if (row >= update.get(0) && row <= update.get(2) && col >= update.get(1) && col <= update.get(3)) {
                value = update.get(4);
            }
        }
        return value;
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */