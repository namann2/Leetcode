```
class Solution {
    public int maximalRectangle(char[][] matrix) {
        // This is an extension to maximum rectangle in a histogram
        LargestRectangleInHistogram helper = new LargestRectangleInHistogram();
        // N = rows, M = cols;
        // TC : O(NM * N), SC : O(M + NM) - stack takes max of col elements in one go
        int maxArea = 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[]dp = new int[cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(matrix[i][j]-'0' == 1)
                    dp[j] += matrix[i][j]-'0';
                else dp[j] = 0;
            }
            maxArea = Math.max(maxArea, helper.largestRectangleArea(dp));
        }
        return maxArea;
    }
}

class LargestRectangleInHistogram {
    
    public int largestRectangleArea(int[] heights) {
        System.out.println(Arrays.toString(heights));
        int n = heights.length;
        int[] L = new int[n];
        int[] R = new int[n];
        
        getSmallestOnLeft(heights, L, n);
        getSmallestOnRight(heights, R, n);
        
        int max_area = 0;
        for(int i=0;i<n;i++) {
            max_area = Math.max(max_area, heights[i] * (R[i] - L[i] - 1));
        }
        return max_area;
    }
    
    private void getSmallestOnLeft(int[] heights, int[] A, int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            A[i] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(i);
        }
    }
    
    private void getSmallestOnRight(int[] heights, int[] A, int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            A[i] = stack.size() == 0 ? n : stack.peek();
            stack.push(i);
        }
    }
}
```​
