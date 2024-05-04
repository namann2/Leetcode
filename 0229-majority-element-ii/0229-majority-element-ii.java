class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // determine how many majority elements are possible : done
        List<Integer> answer = new ArrayList<>();
        int m1 = 0, m2 = 0;
        int c1 = 0, c2 = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] == m1) c1++;
            else if(nums[i] == m2) c2++;
            else if(c1 == 0) {
                c1 = 1;
                m1 = nums[i];
            } else if(c2 == 0) {
                c2 = 1;
                m2 = nums[i];
            } else {
                c1--;
                c2--;
            }
        }
        
        c1 = c2 = 0;
        for(int num : nums) {
            if(num == m1) c1++;
            if(num == m2) c2++;
        }

        if(c1 > n/3) answer.add(m1);
        if(c2 > n/3 && m1 != m2) answer.add(m2);
        return answer;
    }
}
/*

n       required count of numbers       max count of maj elements
        for them to be a majority
1       c(1/3) + 1 = 1                          1
2       c(2/3) + 1 = 1                          2
3       c(3/3) + 1 = 2                          1
4       c(4/3) + 1 = 2                          2 
5
6       c(6/3) + 1 = 3                          2
7
8
9       c(9/3) + 1 = 4                          2
10
30
19      c(19/3) + 1 = 7                         
*/