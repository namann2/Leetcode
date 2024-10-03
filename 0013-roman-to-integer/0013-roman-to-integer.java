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

/*
CXLIII
I, II, III, IV, 1-4
V, VI, VII, VIII, IX 5-9
X, XI, XII, XIII, XIV, .....XL(40), XLI, XLII....XLIX, L

IV - 4
IX - 9
XIV - 14
XIX - 19
XXIV - 24
XXIX - 29
XXXIV - 34
XXXIX - 39
XL - 40
*/