class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> maps = new HashMap<>();
        maps.put('I', 1);
        maps.put('V', 5);
        maps.put('X', 10);
        maps.put('L', 50);
        maps.put('C', 100);
        maps.put('D', 500);
        maps.put('M', 1000);
        
        int n = s.length(), num = maps.get(s.charAt(n-1));
        for(int i = n-2; i >= 0; i--) {
            char curr = s.charAt(i);
            char next = s.charAt(i+1);
            if(curr == 'I' && (next == 'V' || next == 'X')) num -= 1;
            else if(curr == 'X' && (next == 'L' || next == 'C')) num -= 10;
            else if(curr == 'C' && (next == 'D' || next == 'M')) num -= 100;
            else num += maps.get(curr);
        }
        return num;
    }
}