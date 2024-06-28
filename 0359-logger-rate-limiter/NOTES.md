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
​
### Solution2 : HashMap ( I use this )
​
The `ConcurrentModificationException` in Java is thrown when a collection (such as a `HashMap`) is structurally modified while an iterator is being used to traverse the collection. Structural modification means adding, removing, or changing elements in the collection, which can invalidate the iterator and lead to this exception.
​
Using an `Iterator` to remove elements from a collection is a safe way to avoid `ConcurrentModificationException` because the iterator provides a mechanism to safely remove elements during iteration.
​
### How Iterator Helps Avoid `ConcurrentModificationException`
​
When you use an iterator to traverse a collection, it keeps track of the current position in the collection. If you remove elements using the iterator's `remove()` method, the iterator updates its internal state to reflect the removal, preventing the `ConcurrentModificationException`.
​
###### Summary
​
- **Using an Iterator**: When you need to remove elements from a collection during iteration, use an iterator and its `remove()` method. This approach ensures that the internal state of the iterator remains consistent, avoiding the `ConcurrentModificationException`.
- **ConcurrentModificationException**: This exception occurs when a collection is structurally modified while being traversed by an iterator. The iterator's `remove()` method safely handles such modifications.
​
```
​
TC : O(n)
SC : O(n)
​
class Logger {
private HashMap<String, Integer[]> loggerInfo;
public Logger() {
this.loggerInfo = new HashMap<>();
}
public boolean shouldPrintMessage(int timestamp, String message) {
cleanup(timestamp);