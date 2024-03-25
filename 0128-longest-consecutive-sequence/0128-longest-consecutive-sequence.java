class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;
        
        Set<Integer> numbers = new HashSet<>();
        for(int num : nums) numbers.add(num);
        
        int answer = 1;
        
        for(int num : nums) {
            // why ? bcz then num will become the part of a sequence
            if(numbers.contains(num-1))  
                continue; 
            int local = 1;
            while(numbers.contains((num++) + 1)) local++;
            answer = Math.max(answer, local);
        }
        return answer;
    }
}