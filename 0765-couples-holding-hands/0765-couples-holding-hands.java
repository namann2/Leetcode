class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        Map<Integer, Integer> elementIndexMap = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            elementIndexMap.put(row[i], i);
        }
        
        int swaps = 0;
        for(int i = 0; i < n-1; i+=2) {
            int firstElement = row[i];
            int secondElement = row[i] ^ 1;
            // do we need to make a swap ?
            if(row[i+1] != secondElement) {
                swaps++;
                swap(i+1, elementIndexMap.get(secondElement), row, elementIndexMap);
            }
        }
        return swaps;
    }
    
    private void swap(int a, int b, int[] row, Map<Integer, Integer> elementIndexMap) {
        int tmp = row[a];
        row[a] = row[b];
        row[b] = tmp;
        
        tmp = elementIndexMap.get(row[a]);
        elementIndexMap.put(row[a], b);
        elementIndexMap.put(row[b], tmp);
    }
}