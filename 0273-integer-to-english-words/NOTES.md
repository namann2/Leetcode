Given the recursive nature of the function, the total number of recursive calls is proportional to the number of digits in the number. Specifically:
​
For each billion, the function makes a recursive call for millions.
For each million, it makes a recursive call for thousands.
For each thousand, it makes a recursive call for hundreds.
​
Let's denote d as the number of digits in n. In the worst case, d is approximately
`log 10(n)+1`
​
​
### Space Complexity
Call Stack: The depth of the recursive calls corresponds to the number of divisions needed to reduce the number to a single digit. This depth is proportional to the number of digits in the number, leading to a space complexity for the call stack.
​
StringBuilder: The space used by the StringBuilder is proportional to the number of characters in the final string representation of the number. The length of the string representation of a number is linear with respect to the number of digits.
​
`log 10(n)+1`