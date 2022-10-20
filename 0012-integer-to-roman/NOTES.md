# Analysis : 
`TC` : O(1) 
As there is a finite set of roman numerals, there is a hard upper limit on how many times the loop can iterate. <br>
This upper limit is 15 times, and it occurs for the number 3888, which has a representation of MMMDCCCLXXXVIII. <br>
Therefore, we say the time complexity is constant, i.e. O(1). <br>

`SC` : O(1) <br>


# Approach 1 : 

```
class Solution {
    public String intToRoman(int num) {
        TreeMap<Integer, String> map = new TreeMap<>();
        
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        StringBuilder op = new StringBuilder();
        while(num > 0) {
            int x = map.floorKey(num);
            int freq = num / x;
            num -= x * freq;
            while(freq-- > 0)
                op.append(map.get(x));
        }
        return op.toString();
    }
}

```

# Approach 2 : 

```
class Solution {
    public String intToRoman(int num) {
        if(num == 0)
            return "";
        
        StringBuilder answer = new StringBuilder();
        
        if(num >= 1000)
            return answer.append("M").append(intToRoman(num - 1000)).toString();
        if(num >= 900)
            return answer.append("CM").append(intToRoman(num - 900)).toString();
        if(num >= 500)
            return answer.append("D").append(intToRoman(num - 500)).toString();
        if(num >= 400)
            return answer.append("CD").append(intToRoman(num - 400)).toString();
        if(num >= 100)
            return answer.append("C").append(intToRoman(num - 100)).toString();
        if(num >= 90)
            return answer.append("XC").append(intToRoman(num - 90)).toString();
        if(num >= 50)
            return answer.append("L").append(intToRoman(num - 50)).toString();
        if(num >= 40)
            return answer.append("XL").append(intToRoman(num - 40)).toString();
        if(num >= 10)
            return answer.append("X").append(intToRoman(num - 10)).toString();
        if(num >= 9)
            return answer.append("IX").append(intToRoman(num - 9)).toString();
        if(num >= 5)
            return answer.append("V").append(intToRoman(num - 5)).toString();
        if(num >= 4)
            return answer.append("IV").append(intToRoman(num - 4)).toString();
        if(num >= 1)
            return answer.append("I").append(intToRoman(num - 1)).toString();
        
        return answer.toString();
    }
}
```
