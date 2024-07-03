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
        int total = n, removed = 0;
        while(left <= right) {
            if(total - removed - A[right] > total - removed - A[left]) {
                removed += A[left];
                left++;
            } else {
                removed += A[right];
                right--;
            }
            ans++;
            if(total - removed <= total / 2) return ans;
        }
        return ans;
    }
}