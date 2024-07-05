class MKAverage {
    int m, k;
    TreeMap<Integer, Integer> smaller, middle, largest;
    int middleSum, smallerSize, largestSize;
    
    Deque<Integer> q;
    
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.smaller = new TreeMap<>();
        this.middle = new TreeMap<>();
        this.largest = new TreeMap<>();
        this.q = new ArrayDeque<>();
    }
    
    public void addElement(int num) {
        q.addLast(num);
        // update in map
        updateUtil(num);
        
        if(q.size() > m) {
            int rm = q.removeFirst();
            removeUtil(rm);
        }
    }
    
    public int calculateMKAverage() {
        if(q.size() < m)
            return -1;
        return (int)(middleSum / (m - 2*k));
    }
    
    // helper function
    
    private void updateUtil(int num) {
        updateMap(largest, num);
        largestSize++;
        
        if(largestSize > k) {
            int smallestNum = largest.firstKey();
            removeMap(largest, smallestNum);
            largestSize--;
            
            updateMap(smaller, smallestNum);
            smallerSize++;
        }
        
        if(smallerSize > k) {
            int largestNum = smaller.lastKey();
            removeMap(smaller, largestNum);
            smallerSize--;
            
            updateMap(middle, largestNum);
            middleSum += largestNum;
        }
        
    }

    private void removeUtil(int num) {
        // cases
        if(largest.containsKey(num)) { // largest map contains the extra element
            removeMap(largest, num);
            int largestNum = middle.lastKey();
            removeMap(middle, largestNum);
            middleSum -= largestNum;
            updateMap(largest, largestNum);
        } else if(smaller.containsKey(num)) {
            removeMap(smaller, num);
            int smallestNum = middle.firstKey();
            removeMap(middle, smallestNum);
            middleSum -= smallestNum;
            updateMap(smaller, smallestNum);
        } else {
            removeMap(middle, num);
            middleSum -= num;
        }
    }
    
    // update the val in map
    private void updateMap(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }
    
    // remove val from map
    private void removeMap(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.get(val) - 1);
        if(map.get(val) == 0)
            map.remove(val);
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */