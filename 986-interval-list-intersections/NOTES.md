```
class Solution {
public int[][] intervalIntersection(int[][] A, int[][] B) {
if(A==null || B==null) return null;
// if(B==null) return A;
int i=0,j=0;
ArrayList<int[]> result = new ArrayList<>();
int n = A.length, m = B.length;
while(i<n && j<m) {
// check if there is an overlap
int[] Ai = A[i];
int[] Bj = B[j];
// if overlap
int start = Math.max(Ai[0], Bj[0]);
int end = Math.min(Ai[1], Bj[1]);
if(end >= start) result.add(new int[]{start, end});
if(Ai[1]==end) i++;
if(Bj[1]==end) j++;
}
int[][] R = new int[result.size()][2];
int idx = 0;
for(int k=0;k<R.length;k++)
R[idx++] = result.get(k);