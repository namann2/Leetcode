# My thinking :
If we divide a number by k then, possible remainders are from [0, k-1]
There are + , - and 0 remainders.
​
If we have two numbers a and b.
if remainder(a % k) = x, then for
(a+b) % k == 0 ,
​
(b%k) should be -x as (x+ -x == 0). Negative remainders are not easy to handle, hence, make them positive. So, eventually we are looking for remainders
`x & 60-x`
​
​
# Helpful :
​
https://www.youtube.com/watch?v=BvKv-118twg