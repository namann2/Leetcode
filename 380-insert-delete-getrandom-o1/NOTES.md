# Logic : 
we need a hashmap to be able to tell that the certain number exist or not.
as we also have to tell the random number, hence it makes sense to use a list 
to get the range over index and return the value at that index

Now, the question is what will the hashmap store as a k-v ?
k - the value which we are inserting
v - what would this be ?

suppose we are removing a value from our ds, we need to do it in O(1) TC in average case
So, we need its index to be removed with the last element in the locations list. Hence, we  will use index of the value as "value in hashmap"
		
		
```
class RandomizedSet {
    
    private ArrayList<Integer> locations;
    private HashMap<Integer, Integer> hashmap;
    
    public RandomizedSet() {
        locations = new ArrayList<>();
        hashmap = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean contains = hashmap.containsKey(val);
        if(contains) return false;
        
        locations.add(val);
        hashmap.put(val, locations.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        boolean contains = hashmap.containsKey(val);
        if(!contains) return false;
        
        int indexOfValue = hashmap.get(val);
        int lastIndex = locations.size()-1;
        int lastValue = locations.get(lastIndex);
        
        if(indexOfValue != lastIndex) {
            locations.set(indexOfValue, lastValue);
            hashmap.put(lastValue, indexOfValue);
        }
        
        locations.remove(lastIndex);
        hashmap.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        int min = 0, max = locations.size();
        int index = (int)(Math.random() * (max-min) + min);
        return locations.get(index);
    }
}
```
