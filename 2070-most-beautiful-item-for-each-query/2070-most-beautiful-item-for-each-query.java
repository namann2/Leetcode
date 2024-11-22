class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // create a mapping of max beauty for a price
        Arrays.sort(items, (item1, item2) -> {
            return item1[0] - item2[0];
        });
        
        int maxBeautySoFar = -1;
        TreeMap<Integer, Integer> maxBeauty = new TreeMap<>();
        for(int[] item : items) { // O(n)
            maxBeautySoFar = Math.max(maxBeautySoFar, item[1]);
            maxBeauty.put(item[0], maxBeautySoFar);
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