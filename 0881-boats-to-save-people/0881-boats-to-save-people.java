class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int left = 0, right = n-1;
        int cnt = 0;
        while(left <= right) {
            int cweight = people[left] + people[right];
            if(cweight <= limit) left++;
            cnt++;
            right--;
        }
        return cnt;
    }
}