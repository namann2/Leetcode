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
​
/*
Say now we have {1,2,3} and add {4} into it. Apparently, the new subarray introduced here are: