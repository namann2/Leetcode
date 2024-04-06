The time complexity of the fractionToDecimal method primarily depends on
1. the length of the resulting decimal fraction and,
2. whether there's a repeating decimal pattern
​
​
### TC :
If there's no repeating pattern, this part has a time complexity of `O(log(N/D))` in the worst case
​<br>
If there is a repeating pattern, the loop to find the repeating part can iterate at most D times before finding the pattern, hence O(D)
​
### SC :
StringBuilder answer : O(log10(N/D))
Map : size can grow up to D entries in the worst case
SC : `O(log10(N/D) + D)`
