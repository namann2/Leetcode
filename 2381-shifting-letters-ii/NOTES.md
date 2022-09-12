# Hint :
Lets say we are given
[1,10000] and [2,10000] intervals and
we are supposed to increase the count of values between 1 to 10000 and 2 to 10000 by x.
So how you will do?
Brute force is to iterate over each interval and
increase each position count that is appearing in intervals.
Can we do better? YES !
Lets create a array from index 0 to 1e5.
Now iterate over each interval.Eg.:-
[1,10000]:- increase the counter at pos 1 by x and decrease at 10001 by x.
​
Same for other intervals.
Now do prefix sum.
This will incerase each position value in linear time
​