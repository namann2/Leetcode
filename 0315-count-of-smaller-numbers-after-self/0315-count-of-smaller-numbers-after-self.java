class Pair {
    int index, value;
    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;
        int[] count = new int[n];
        
        Pair[] OG = new Pair[n];
        for(int i = 0; i < n; i++)
            OG[i] = new Pair(i, nums[i]);
        
        mergeSort(OG, new Pair[n], count, 0, n-1);
        
        for(int x : count)
            answer.add(x);
        
        return answer;
    }
    
    private void mergeSort(Pair[] OG, Pair[] temp, int[] count, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd)
            return;
        
        int mid = leftStart + (rightEnd - leftStart) / 2;
        mergeSort(OG, temp, count, leftStart, mid);
        mergeSort(OG, temp, count, mid + 1, rightEnd);
        mergeHalves(OG, temp, count, leftStart, rightEnd);
    }
    
    private void mergeHalves(Pair[] OG, Pair[] temp, int[] count, int leftStart, int rightEnd) {
        int leftEnd = leftStart + (rightEnd - leftStart) / 2; 
        int rightStart = leftEnd + 1;
        
        int left = leftStart, right = rightStart, index = leftStart;
        
        int cnt = 0;
        while(left <= leftEnd && right <= rightEnd) {
            if(OG[left].value <= OG[right].value) {
                count[OG[left].index] += cnt;
                temp[index ++] = OG[left ++];
            } else { // left.value > right.value means we need to swap values which are smaller than current number
                cnt++;
                temp[index ++] = OG[right ++];
            }
        }
        
        while(left <= leftEnd) {
            count[OG[left].index] += cnt;
            temp[index ++] = OG[left ++];
        }
        while(right <= rightEnd) temp[index ++] = OG[right ++];
        
        for(int i = leftStart; i <= rightEnd; i++) OG[i] = temp[i];
    }
}

/*
1. N^2
2. 

*/