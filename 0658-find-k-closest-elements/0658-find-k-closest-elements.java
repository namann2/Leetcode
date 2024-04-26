class Solution {
    public List<Integer> findClosestElements(int[] A, int k, int x) {
        List<Integer> answer = new ArrayList<>();
        int n = A.length;
        
        int start = 0, end = n-1, ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(A[mid] == x) {
                ans = mid;
                break;
            } else if(A[mid] > x) end = mid - 1;
            else {
                ans = mid;
                start = mid + 1;
            }
        }
        
        int left = ans, right = ans + 1;
        while(left >= 0 && right < n && k-- > 0) {
            int o = Math.abs(A[left] - x), t = Math.abs(A[right] - x);
            if(o <= t) {
                answer.add(A[left--]);
            } else answer.add(A[right++]);
        }
        
        while(left >= 0 && k-- > 0) answer.add(A[left--]);
        while(right < n && k-- > 0) answer.add(A[right++]);
        
        Collections.sort(answer);
        
        return answer;
    }
}