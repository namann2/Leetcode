we need a hashmap to be able to tell that the certain number exist or not.
as we also have to tell the random number, hence it makes sense to use a list
to get the range over index and return the value at that index
​
Now, the question is what will the hashmap store as a k-v ?
k - the value which we are inserting
v - what would this be ?
​
suppose we are removing a value from our ds, we need to do it in O(1) TC in average case
So, we need its index to be removed with the last element in the locations list. Hence, we  will use index of the value as "value in hashmap"
**getRandom function** : `returns [ 0.0, 1.0 )` if we have to find the random value in a range `"min inclusive and max exclusive"` :
​
`Math.random() * ( max - min ) + min`
​
`value returned by Math.random() can be any decimal number greater than or equal to 0.0 and less than 1.0, and each possible value within this range theoretically has an equal probability of occurrence.`
​
​
*****--------****
```
class RandomizedSet {