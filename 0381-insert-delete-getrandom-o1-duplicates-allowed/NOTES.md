Question : 

RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). It should support inserting and removing specific elements and also reporting a random element.

Implement the RandomizedCollection class:

RandomizedCollection() Initializes the empty RandomizedCollection object.

- `bool insert(int val)` Inserts an item val into the multiset, even if the item is already present. Returns true if the item is not present, false otherwise.
- `bool remove(int val)` Removes an item val from the multiset if present. Returns true if the item is present, false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
- `int getRandom()` Returns a random element from the current multiset of elements. The probability of each element being returned is linearly related to the number of the same values the multiset contains.
You must implement the functions of the class such that each function works on average O(1) time complexity.

Note: The test cases are generated such that getRandom will only be called if there is at least one item in the RandomizedCollection.


----- 

Clarifying Questions : 
1. Are duplicates allowed ? ( if not mentioned )
2. Can we invoke getRandom even if there are no elements in the data structure ?

-----

Since, the elements would repeat and we want to have the probability of element to be in linear fashion, we could think of prob in terms of indices rather than elements.

We want the prob of indices to be linear which would make sure that the elements would have prob in linear fashion.

eg: [1,1,2,3,1,4,2]
For each index, the prob should be equal.

## Following code is not working because I made a logical error in understanding the question. Still I am pasting it here to refer to it if in future I make the same error again.

```

import java.util.*;

class RandomizedCollection {
    /*
        requirement is : 
        1 -> 1
        10 -> 5 times
        
        then if we call random function 6 times, 5 times it should return 10 and 1 time it should 
        return 1.
        
        but this is not what i understood while implementing this solution below. I thought the unique values will be having same probability. Which is wrong...
    */
    // value -> freq
    private Map<Integer, Integer> fhashmap; 
    // value -> index of value in location (push unique value in location at store its index)
    private Map<Integer, Integer> ihashmap; 
    // unique values
    private List<Integer> locations; 
    
    public RandomizedCollection() {
        fhashmap = new HashMap<>();
        ihashmap = new HashMap<>();
        locations = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean contains = fhashmap.containsKey(val);
        if (contains) {
            fhashmap.put(val, fhashmap.get(val) + 1);
        } else {
            fhashmap.put(val, 1);
            ihashmap.put(val, locations.size());
            locations.add(val);
        }
        return !contains;
    }
    
    public boolean remove(int val) {
        if (!fhashmap.containsKey(val)) 
            return false;
        
        int lastIndex = locations.size() - 1;
        int lastValue = locations.get(lastIndex);
        int indexToRemove = ihashmap.get(val);
        int freqValue = fhashmap.get(val);
        
        if (freqValue == 1) {
            fhashmap.remove(val);
            ihashmap.remove(val);
            // remove from locations
            if (indexToRemove != lastIndex) {
                locations.set(indexToRemove, lastValue);
                ihashmap.put(lastValue, indexToRemove);
            }   
            locations.remove(lastIndex);
        } else {
            fhashmap.put(val, freqValue - 1);
        }
        return true;
    }
    
    public int getRandom() {
        return locations.get((int) (Math.random() * locations.size()));
    }
}

```​
