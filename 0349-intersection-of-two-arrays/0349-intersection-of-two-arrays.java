class Solution {
    public int[] intersection(int[] A, int[] B) {
        int n = A.length, m = B.length;
        if(n > m) 
            return intersection(B, A);
        
        boolean[] count = new boolean[1001];
        for(int a : A)
            count[a] = true;
        
        List<Integer> ans = new ArrayList<>();
        for(int b : B) {
            if(count[b]) { 
                ans.add(b);
                count[b] = false;
            }
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}