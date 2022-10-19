class Pair {
    int freq;
    String s;
    Pair(String s, int freq) {
        this.freq = freq;
        this.s = s;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            int val = p1.freq - p2.freq;
            if(val != 0) return val;
            return p2.s.compareTo(p1.s);
        });
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String w : words) {
            map.put(w, map.getOrDefault(w, 0)+1);
        }
        
        for(String w : map.keySet()) {
            pq.add(new Pair(w, map.get(w)));
            if(pq.size() > k)
                pq.poll();
        }
        
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()) 
            result.add(pq.poll().s);
        
        Collections.reverse(result);
        return result;
    }
}