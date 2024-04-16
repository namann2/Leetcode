class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int L = 0, R = col-1;
        int T = 0, B = row-1;
        
        int direction = 0;
        while(answer.size() < row * col) { // or T<=B && L<=R
            if(direction == 0) {
                for(int i = L; i <= R; i++) {
                    answer.add(matrix[T][i]);
                }
                T++;
            } else if(direction == 1) {
                for(int i = T; i <= B; i++) {
                    answer.add(matrix[i][R]);
                }
                R--;
            } else if(direction == 2) {
                for(int i = R; i >= L; i--) {
                    answer.add(matrix[B][i]);
                }
                B--;
            } else if(direction == 3) {
                for(int i = B; i >= T; i--) {
                    answer.add(matrix[i][L]);
                }
                L++;
            }
            direction = (direction + 1) % 4;
        }
        return answer;
    }
}