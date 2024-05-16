class RandomizedSet {

    private Map<Integer, Integer> map;
    private ArrayList<Integer> locations;
    public RandomizedSet() {
        map = new HashMap<>();
        locations = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if(contains)
            return false;
        
        map.put(val, locations.size());
        locations.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        boolean contains = map.containsKey(val);
        if(!contains)
            return false;
        
        int index = map.get(val);
        
        int lastIndex = locations.size()-1;
        
        if(index != lastIndex) {
            locations.set(index, locations.get(lastIndex));
            map.put(locations.get(index), index);
        }
        map.remove(val);
        locations.remove(lastIndex);
        return true;
    }
    
    public int getRandom() {
        int min = 0, max = locations.size();
        int randomIndex = (int)(Math.random() * (max - min) + min);
        return locations.get(randomIndex);
    }
}
