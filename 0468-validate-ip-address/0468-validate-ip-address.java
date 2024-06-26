class Solution {
    public String validIPAddress(String queryIP) {
        int dots = 0, colon = 0;
        int n = queryIP.length();
        for(int i = 0; i < n; i++) {
            char ch = queryIP.charAt(i);
            if(ch == '.') dots++;
            else if(ch == ':') colon++;
        }
        
        if(dots == 3) return isValidIPV4(queryIP);
        else if(colon == 7) return isValidIPV6(queryIP);
        return "Neither";
    }
    
    private String isValidIPV4(String IP) {
        String[] parts = IP.split("\\.", -1);
        for(String part : parts) {
            // if(part.equals("")) return "Neither";
            if(part.length() == 0 || part.length() > 3) return "Neither";
            if(part.charAt(0) == '0' && part.length() > 1) return "Neither";
            for(char ch : part.toCharArray()) {
                if(!Character.isDigit(ch)) return "Neither";
            }
            if(Integer.valueOf(part) > 255) return "Neither";
        }
        return "IPv4";
    }
    
    private String isValidIPV6(String IP) {
        String[] parts = IP.split("\\:", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for(String part : parts) {
            // if(part.equals("")) return "Neither";
            if(part.length() == 0 || part.length() > 4) return "Neither";
            for(char ch : part.toCharArray()) {
                if(hexdigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }
}