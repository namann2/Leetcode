class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> seen = new HashSet<>();
        
        String[] T = s.split("\\s+");
        
        if(T.length != pattern.length()) return false;
        
        for(int i=0;i<T.length;i++) {
            char ch = pattern.charAt(i);
            String curr = T[i];
            
            if(!map.containsKey(ch)) {
                if(seen.contains(curr)) return false;
                map.put(ch, curr);
                seen.add(curr);
            } else {
                if(!map.get(ch).equals(curr)) return false;
            }
        }
        return true;
    }
}

/*

"abba" -> "dog cat cat dog"
    
    
    dog, cat
    
    
 a->dog
 b->cat

if not in map but in seen then false



*/