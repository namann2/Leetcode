class RandomizedSet {
    
    private List<Integer> locations;
    private Map<Integer, Integer> map;
    public RandomizedSet() {
        locations = new ArrayList<>();
        map = new HashMap<>();
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
        if(!contains) return false;
        
        int lastIndex = locations.size()-1;
        int index = map.get(val);
        if(index != lastIndex) {
            int last = locations.get(lastIndex);
            locations.set(index, last);
            map.put(last, index);
        }
        locations.remove(lastIndex);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int random = (int)(Math.random() * locations.size());
        return locations.get(random);
    }
}