class Pair {
    
    private int index, value;
    
    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
    
    // getter and setter
    public int getIndex() {
        return this.index;
    }
    
    public int getValue() {
        return this.value;
    }
}
class Solution {
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        
        Pair[] indexValue = new Pair[n];
        for(int i = 0; i < n; i++)
            indexValue[i] = new Pair(i, nums[i]);
        
        mergeSort(indexValue, new Pair[n], count, 0, n-1);
        
        List<Integer> countSmallerNumbers = new ArrayList<>();
        for(int smallerCount : count)
            countSmallerNumbers.add(smallerCount);
        
        return countSmallerNumbers;
    }
    
    private void mergeSort(Pair[] indexValue, Pair[] temp, int[] count, int leftStart, int rightEnd) {
        // base case
        if(leftStart >= rightEnd)
            return;
        int mid = leftStart + (rightEnd - leftStart) / 2;
        mergeSort(indexValue, temp, count, leftStart, mid);
        mergeSort(indexValue, temp, count, mid + 1, rightEnd);
        mergeHalves(indexValue, temp, count, leftStart, rightEnd);
    }
    
    private void mergeHalves(Pair[] indexValue, Pair[] temp, int[] count, int leftStart, int rightEnd) {
        int leftEnd = leftStart + (rightEnd - leftStart) / 2;
        int rightStart = leftEnd + 1;
        
        int left = leftStart, right = rightStart, index = leftStart;
        int cnt = 0;
        while(left <= leftEnd && right <= rightEnd) {
            Pair leftPair = indexValue[left];
            Pair rightPair = indexValue[right];
            if(leftPair.getValue() > rightPair.getValue()) {
                cnt++;
                temp[index ++] = indexValue[right ++];
            } else { // leftValue <= rightValue
                count[leftPair.getIndex()] += cnt;
                temp[index ++] = indexValue[left ++];
            }
        }
        
        while(left <= leftEnd) {
            count[indexValue[left].getIndex()] += cnt;
            temp[index ++] = indexValue[left ++];
        }
        
        while(right <= rightEnd) {
            temp[index ++] = indexValue[right ++];
        }
        
        for(int i = leftStart; i <= rightEnd; i++) 
            indexValue[i] = temp[i];
    }
}