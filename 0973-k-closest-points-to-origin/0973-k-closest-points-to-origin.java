class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        
        k = k == n ? n : quickSelect(points, 0, n-1, k);
        
        int[][]ans = new int[k][2];
        int idx = 0;
        
        while(idx < k) {
            ans[idx] = points[idx++];
        }
        return ans;
    }
    
    private int quickSelect(int[][] points, int left, int right, int k) {
        int pi = partition(points, left, right);
        if(pi == k) 
            return pi;
        else if(k > pi)
            return quickSelect(points, pi + 1, right, k);
        return quickSelect(points, left, pi - 1, k);
    }
    
    private int partition(int[][] points, int left, int right) {
        int pivot = right;
        int dis_pivot = dis(points[right]);
        int i = left, j = left;
        
        while(i <= right) {
            if(dis(points[i]) <= dis_pivot) {
                swap(points, i, j);
                i++;
                j++;
            } else i++;
        }
        return j-1;
    }
    
    private int dis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}