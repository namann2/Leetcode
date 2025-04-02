## Time Complexity : 

```
Naive Solution : O(n4) - 4 nested loops
Backtracking Solution : 3^4
    because we have choice to pick 
    
                           2      5525511135
                       /   |    \
               start+1 start+2 start+3
               
               3 choice for each element.
               So, 3^n but this n will break for chunks of 4. So, 3^4


```

## Solution : 

- Time complexity O(3^4) <br>
- Space complexity O(n) for path variable

```
class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<>();
        
        if(s == null || s.length() == 0) return result;
        
        if(s.length() > 12) return result;
        
        restore(s, 0, new ArrayList<String>(), result);
        
        return result;
    }
    
    /*
        We have to pick substrings of atmost 3 length
        Let's say we have a pointer that points to current element ( start ) and we loop from 1 to 3
        and check whether we can form the valid IP from the remaining string, for which the 
        next current element will change so we pass start+i ( +i because start is always pointing to the 
        first element of the window )
    */
    private void restore(String s, int start, ArrayList<String> temp, List<String> result) {
        
        if(start == s.length() && temp.size() == 4) {
            StringBuilder res = new StringBuilder();
            for(String t : temp) {
                res.append(t);
                res.append(".");
            }
            res.deleteCharAt(res.length()-1);
            result.add(res.toString());
            return;
        }
        
        for(int i=1;i<=3;i++) {
            
            if(start+i > s.length()) return;
            
            String prefix = s.substring(start, start+i);
            
            if(isValid(prefix)) {
                temp.add(prefix);
                restore(s, start+i, temp, result);
                temp.remove(temp.size()-1);
            }
        }

    }
    
    private boolean isValid(String address) {
        // 0.011.255.245
        if(Integer.valueOf(address) > 255 || (address.length()>1 && address.charAt(0)=='0')) {
            return false;
        }
        return true;
    }
}


```


# Same Solution but different naming I guess

```
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList();
        if(s==null || s.length()==0 || s.length() > 12) return result;
        
        restore(s, 0, new ArrayList<String>(), result);
        return result;
    }
    private void restore(String s, int start, ArrayList<String> temp, List<String> result) {
        // base case
        if(start == s.length() && temp.size() == 4) {
            StringBuilder fs = new StringBuilder();
            for(String i : temp) {
                fs.append(i);
                fs.append(".");
            } // 2.2.2.4.
            fs.deleteCharAt(fs.length()-1);
            result.add(String.valueOf(fs));
            return;
        }
        // main logic
        for(int i=1;i<=3;i++) {
            // point to note 1 -> not >=
            if(start+i > s.length()) continue;
            
            String prefix = s.substring(start, start+i);
            
            if(isValid(prefix)) {
                temp.add(prefix);
                restore(s, start+i, temp, result); // point to note 3 -> string to pass and the index
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isValid(String address) {
        // point to note 2 -> the condition
        if(Integer.valueOf(address) > 255 || (address.length()>1 && address.charAt(0) == '0'))
            return false;
        return true;
    }
}
```

# Just adding my last submitted code 
```
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> allIps = new ArrayList<>();
        // edge cases
        if(s == null || s.length() == 0 || s.length() > 12) return allIps;
        
        generate(s, 0, new ArrayList<String>(), allIps, s.length());
        return allIps;
    }
    private void generate(String s, int start, List<String> temp, List<String> result, int n) {
        // base case
        if(temp.size() > 4)
            return;
        
        if(start >= n && temp.size() == 4) {
            StringBuilder ip = new StringBuilder();
            for(String st : temp) {
                ip.append(st+".");
            }
            ip.deleteCharAt(ip.length()-1);
            result.add(ip.toString());
            return;
        }
        
        // main logic
        for(int i=1;i<=3;i++) {
            
            if(start + i > n) return;
            
            String prefix = s.substring(start, start+i);
            
            if(isValid(prefix)) {
                temp.add(prefix);
                generate(s, start + i, temp, result, n);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isValid(String group) {
        if((group.length() > 1 && group.charAt(0) == '0') || Integer.valueOf(group) > 255)
            return false;
        return true;
    }
}
```
