class Solution {
    public int[] intersection(int[] A, int[] B) {
        int n = A.length, m = B.length;
        if(n > m) 
            return intersection(B, A);
        
        boolean[] count = new boolean[1001];
        for(int num : A)
            count[num] = true;
        
        List<Integer> result = new ArrayList<>();
        for(int num : B)
            if(count[num]) {
                result.add(num);
                count[num] = false;
            }
        return result.stream().mapToInt(i -> i).toArray();
    }
}