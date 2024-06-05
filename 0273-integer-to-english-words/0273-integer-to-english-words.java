class Solution {
    
    private static String[] LESS_THAN_TEN = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static String[] LESS_THAN_TWENTY = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return wordsHelper(num);
    }
    
    private String wordsHelper(int num) {
        String result = new String();
        if(num < 10) // 7
            result = LESS_THAN_TEN[num];
        else if(num < 20) // 1
            result = LESS_THAN_TWENTY[num - 10];
        else if(num < 100) // 56
            result = TENS[num / 10] + " " + wordsHelper(num % 10);
        else if(num < 1000) // 678
            result = wordsHelper(num / 100) + " Hundred " + wordsHelper(num % 100);
        else if(num < 1000000) // this range will cover all number b/w 1001 - 999999
            result = wordsHelper(num / 1000) + " Thousand " + wordsHelper(num % 1000);
        else if(num < 1000000000) 
            result = wordsHelper(num / 1000000) + " Million " + wordsHelper(num % 1000000);
        else result = wordsHelper(num / 1000000000) + " Billion " + wordsHelper(num % 1000000000);
        return result.trim();
    }
}