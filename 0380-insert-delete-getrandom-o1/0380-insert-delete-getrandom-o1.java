class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> locations;
    
    public RandomizedSet() {
        map = new HashMap<>();
        locations = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if(contains) return false;
        
        map.put(val, locations.size());
        locations.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        boolean contains = map.containsKey(val);
        if(!contains) {
            return false;
        }
        
        int valIndex = map.get(val);
        int lastIndex = locations.size() - 1;
        if(valIndex != lastIndex) {
            map.remove(val);
            int lastElement = locations.get(lastIndex);
            locations.set(valIndex, lastElement);
            map.put(lastElement, valIndex);
            locations.remove(lastIndex);
        } else {
            locations.remove(valIndex);
            map.remove(val);
        }
        return true;
    }
    
    public int getRandom() {
        int min = 0, max = locations.size();
        int randomIndex = (int)(Math.random() * (max - min) + min );
        return locations.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */