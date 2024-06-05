class Solution {
    
    private static final String[] LESS_THAN_TEN = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] LESS_THAN_TWNETY = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String HUNDRED = " Hundred ";
    private static final String THOUSAND = " Thousand ";
    private static final String MILLION = " Million ";
    private static final String BILLION = " Billion ";
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return wordHelper(num);
    }
    
    private String wordHelper(int num) {
        String result = new String();
        if(num < 10)
            result = LESS_THAN_TEN[num];
        else if(num < 20)
            result = LESS_THAN_TWNETY[num - 10];
        else if(num < 100)
            result = TENS[num / 10] + " " + LESS_THAN_TEN[num % 10];
        else if(num < 1000)
            result = LESS_THAN_TEN[num / 100] + HUNDRED + wordHelper(num % 100);
        else if(num < 1000000)
            result = wordHelper(num / 1000) + THOUSAND + wordHelper(num % 1000);
        else if(num < 1000000000)
            result = wordHelper(num / 1000000) + MILLION + wordHelper(num % 1000000);
        else 
            result = wordHelper(num / 1000000000) + BILLION + wordHelper(num % 1000000000);
        return result.trim();
    }
}