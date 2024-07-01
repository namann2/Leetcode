class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        
        // find next smaller element on left and right
        int[] L = new int[n];
        int[] R = new int[n];
        
        findSmallerOnLeft(L, heights, stack);
        stack.clear();
        findSmallerOnRight(R, heights, stack);
        
        
        // System.out.println(Arrays.toString(L));
        // System.out.println(Arrays.toString(R));
        
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (R[i] - L[i] - 1));
        }
        
        return maxArea;
    }
    
    private void findSmallerOnRight(int[] R, int[] heights, Deque<Integer> stack) {
        int n = heights.length;
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peekLast()])
                stack.removeLast();
            R[i] = stack.size() == 0 ? n : stack.peekLast();
            stack.addLast(i);
        }
    }
    
    private void findSmallerOnLeft(int[] L, int[] heights, Deque<Integer> stack) {
        int n = heights.length;
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peekLast()])
                stack.removeLast();
            L[i] = stack.size() == 0 ? -1 : stack.peekLast();
            stack.addLast(i);
        }
    }
}