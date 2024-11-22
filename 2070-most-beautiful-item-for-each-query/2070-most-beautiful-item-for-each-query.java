class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // create a mapping of max beauty for a price
        TreeMap<Integer, Integer> maxBeauty = new TreeMap<>();
        // O(n log m) + O(q log m)
        for(int[] item : items) { // O(n)
            maxBeauty.putIfAbsent(item[0], item[1]);
            int max = Math.max(maxBeauty.get(item[0]), item[1]);
            maxBeauty.put(item[0], max);
        }
        
        int max = -1;
        for(int itemPrice : maxBeauty.keySet()) {
            int currMax = maxBeauty.get(itemPrice);
            max = Math.max(max, currMax);
            maxBeauty.put(itemPrice, max);
        }
        
        int n = queries.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            int query = queries[i];
            Integer floorPrice = maxBeauty.floorKey(query); // logM, where M is the unique priced items 
            if(floorPrice != null)
                answer[i] = maxBeauty.get(floorPrice);
        }
        
        return answer;
    }
    
}