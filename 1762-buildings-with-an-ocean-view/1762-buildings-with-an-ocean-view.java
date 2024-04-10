class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        int maxHeight = heights[n-1];
        Deque<Integer> answer = new ArrayDeque<>();
        answer.addFirst(n-1);
        for(int i=n-2;i>=0;i--) {
            if(heights[i] > maxHeight) answer.addFirst(i);
            maxHeight = Math.max(maxHeight, heights[i]);
        }
        int[]ans = new int[answer.size()];
        int idx = 0;
        while(!answer.isEmpty()) 
            ans[idx++] = answer.removeFirst();
        return ans;
    }
}