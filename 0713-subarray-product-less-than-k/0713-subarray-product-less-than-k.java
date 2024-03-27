class Solution {
    public int numSubarrayProductLessThanK(int[] A, int k) {
        
        if(k==0)
            return 0;
        
        int n = A.length;
        int begin = 0, end = 0, product = 1, cnt = 0;
        while(end < n) {
            product = product * A[end];
            if(product < k)
                cnt += end - begin + 1; // number of elements = number of subarrays whose product is k
            else {
                while(begin <= end && product >= k) 
                    product = product / A[begin++];
                cnt += end - begin + 1;
            }
            end++;
        }
        return cnt;
    }
}

/*
Say now we have {1,2,3} and add {4} into it. Apparently, the new subarray introduced here are:
{1,2,3,4}, {2,3,4}, {3,4}, {4}, which is the number of elements in the new list.
If we also remove some at the left, say we we remove 1, then subarrays are:
{2,3,4}, {3,4}, {4}. It is easy to get the result is j - i + 1.
*/