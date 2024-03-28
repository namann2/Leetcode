class Solution {
    public int largestRectangleArea(int[] heights) {
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