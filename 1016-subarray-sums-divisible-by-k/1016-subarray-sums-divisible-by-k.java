class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        /*
        * Logic : a subarray sum from index i+1 to j is divisible by k if and only if the prefix sum up to j and 
        * the prefix sum up to i have the exact same remainder when divided by k.
        */
        int n = nums.length;
        // remainder, frequency of the remainder ending at index i
        Map<Long, Integer> remainderFrequency = new HashMap<>();
        // for the cases remainder = 0
        remainderFrequency.put(0l, 1);
        long sum = 0l;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            long remainder = (sum % k + k) % k; // for negative sum values => sum % k would result neg remainder
            answer += remainderFrequency.getOrDefault(remainder, 0);
            remainderFrequency.put(remainder, remainderFrequency.getOrDefault(remainder, 0) + 1);
        }
        return answer;
    }
}