class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        // greedy - sort, pq, sort + pq, line-sweep
        
        // We want to maximize the product A * B
        // where A = sum(k values) & B = min(k values)
        // to maximize A*B, let's keep one value constant and find other one
        // min(k values) should be as large as possible and we need to remove
        // those engineers who have less speed

        // Hence -> 
        // Performance = sum(speed) * min(efficiency). 
        // Try every efficiency value from highest to lowest and at the same time 
        // maintain an as-large-as-possible speed group, keep adding speed to total speed, 
        // if size of engineers group exceeds K, lay off the engineer with lowest speed.


        Pair[] engineers = new Pair[n];
        for(int i=0;i<n;i++)
            engineers[i] = new Pair(efficiency[i], speed[i]);
        
        Arrays.sort(engineers, (d1, d2) -> {
            return d2.eff - d1.eff;
        });
        
        long maxperformance = 0, speedSum = 0;
        int mod = (int)1e9+7;
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2)-> {
            return p1.spd - p2.spd;
        });
        
        for(Pair person : engineers) {
            int eff = person.eff;
            int spd = person.spd;
            
            minHeap.add(person);
            
            if(minHeap.size() > k) {
                Pair out = minHeap.poll();
                speedSum -= out.spd;
            }
            
            speedSum += person.spd;

            maxperformance = Math.max(maxperformance, speedSum * eff);
        }
        return (int)(maxperformance % mod);
    }
}
class Pair {
    int eff, spd;
    Pair(int eff, int spd) {
        this.eff = eff;
        this.spd = spd;
    } 
}
