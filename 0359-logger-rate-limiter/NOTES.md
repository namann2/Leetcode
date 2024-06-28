### Solution 3 : Queue and Map

```
TC : O(n)
SC : O(n)

class Logger {
    // check notes : 
    
    // This is better in terms of space. as we are limiting the size of map
    private Queue<String> q; //holds all the words that came in last 10 seconds
    private HashMap<String, Integer> map; //stores (word existing in q, timestamp last printed)

    /** Initialize your data structure here. */
    public Logger() {
        q = new LinkedList<>();
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        
        //process q, get rid of words printed 10 seconds ago
        while(!q.isEmpty() && timestamp >= map.get(q.peek()) + 10) {
            map.remove(q.poll()); 
        }
        
        //see if word exists
        if(!map.containsKey(message)) {
            q.offer(message);
            map.put(message, timestamp);
            return true;
        } else { //word already exists in q
            return false;
        }
        
    }
}
```

### Solution2 : HashMap ( I use this )

The `ConcurrentModificationException` in Java is thrown when a collection (such as a `HashMap`) is structurally modified while an iterator is being used to traverse the collection. Structural modification means adding, removing, or changing elements in the collection, which can invalidate the iterator and lead to this exception.

Using an `Iterator` to remove elements from a collection is a safe way to avoid `ConcurrentModificationException` because the iterator provides a mechanism to safely remove elements during iteration.

### How Iterator Helps Avoid `ConcurrentModificationException`

When you use an iterator to traverse a collection, it keeps track of the current position in the collection. If you remove elements using the iterator's `remove()` method, the iterator updates its internal state to reflect the removal, preventing the `ConcurrentModificationException`.

###### Summary

- **Using an Iterator**: When you need to remove elements from a collection during iteration, use an iterator and its `remove()` method. This approach ensures that the internal state of the iterator remains consistent, avoiding the `ConcurrentModificationException`.
- **ConcurrentModificationException**: This exception occurs when a collection is structurally modified while being traversed by an iterator. The iterator's `remove()` method safely handles such modifications.

```

TC : O(1), 
In the worst case, you may have to iterate through and remove up to 10 entries. The iteration is O(1) for each removal, so removing 10 entries would be O(10), which simplifies to O(1) in the worst case because the number of entries you remove is bounded by 10.

SC : O(n), where n is the number of distinct messages received within the last 10 seconds.

class Logger {

    private Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        Iterator<String> it = map.keySet().iterator(); 
        while(it.hasNext()) {
            String key = it.next();
            if(timestamp - 10 > map.get(key)) {
              it.remove(); // if we do map.remove(key) it will create concurrentHashMapError
            }
        }
        
        if(!map.containsKey(message) || (map.get(message) <= timestamp)) {
            map.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}


```


### Soution 1 : 
Disadvantage of this solution : Memory usage keeps on increasing

```

TC : O(1)
SC : O(n)


class Pair {
    int _ts, nextAllowedTs;
    Pair(int _ts, int nextAllowedTs) {
        this._ts = _ts;
        this.nextAllowedTs = nextAllowedTs;
    }
}
class Logger { 
    HashMap<String, Pair> loggerInfo;
    
    public Logger() {
       loggerInfo = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int ts, String message) {
        
        if(!loggerInfo.containsKey(message)) {
            loggerInfo.put(message, new Pair(ts, ts+10));
            return true;
        }
        else {
            if(ts >= loggerInfo.get(message).nextAllowedTs) {
                Pair get = loggerInfo.get(message);
                get._ts = ts;
                get.nextAllowedTs = ts+10;
                return true;
            }
            else return false;
        }
    }
}

 ```
