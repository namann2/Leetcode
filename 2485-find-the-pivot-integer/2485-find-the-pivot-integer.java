class Solution {
    public int pivotInteger(int n) {
        int start = 1, end = n;
        int total = sum(n);
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int sm = sum(mid), sr = total - sm + mid;
            if(sm == sr)
                return mid;
            else if(sm > sr) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
    private int sum(int n) {
        return (n * (n + 1)) / 2;
    }
}