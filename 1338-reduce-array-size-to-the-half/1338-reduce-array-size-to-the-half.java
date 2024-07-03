class Solution {
    public int minSetSize(int[] B) {
        int n = B.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int b : B) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        
        int[] A = new int[n];
        int idx = 0;
        for(int b : map.values()) {
            A[idx++] = b;
        }
        
        Arrays.sort(A);
        
        int left = 0, right = n - 1, ans = 0;
        int total = n, removed = 0, remaining = total;
        while(left <= right) {
            if(remaining - A[right] > remaining - A[left]) {
                removed += A[left++];
            } else {
                removed += A[right--];
            }
            ans++;
            remaining = total - removed;
            if(remaining <= total / 2) return ans;
        }
        return ans;
    }
}