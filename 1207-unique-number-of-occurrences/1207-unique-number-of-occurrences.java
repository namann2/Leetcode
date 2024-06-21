class Solution {
    public boolean uniqueOccurrences(int[] A) {
        int[] count = new int[2001];
        int REF = 1000;
        for(int number : A)
            count[number + REF]++;
        
        Set<Integer> unique = new HashSet<>();
        for(int i = 0; i < 2001; i++)
            if(count[i] > 0 && !unique.add(count[i])) 
                return false;
        
        return true;
    }
}