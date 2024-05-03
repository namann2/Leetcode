class Solution {
    public int compareVersion(String version1, String version2) {
        String[] A = version1.split("\\.");
        String[] B = version2.split("\\.");
        int n = A.length, m = B.length;
        int max = Math.max(n ,m);
        for(int i = 0;i < max; i++){
            int num1 = i >= n ? 0 : Integer.parseInt(A[i]);
            int num2 = i >= m ? 0 : Integer.parseInt(B[i]);
            if(num1 < num2) return -1;
            if(num1 > num2) return 1;
        }

        return 0;
    }
}