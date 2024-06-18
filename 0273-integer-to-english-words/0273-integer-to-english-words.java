class Solution {
    
    private static final String[] LESS_THAN_TEN = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        private static final String[] LESS_THAN_TWENTY = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        private static final String HUNDRED = " Hundred ";
        private static final String THOUSAND = " Thousand ";
        private static final String MILLION = " Million ";
        private static final String BILLION = " Billion ";
        private static final String DEL = " ";
    
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        return numberToWordsHelper(num);
    }
    
    private String numberToWordsHelper(int num) {
        StringBuilder result = new StringBuilder();
        if(num < 10)
            result.append(LESS_THAN_TEN[num]);
        else if(num < 20) // 14
            result.append(LESS_THAN_TWENTY[num - 10]);
        else if(num < 100) // 67
            result.append(TENS[num / 10]).append(DEL).append(numberToWordsHelper(num % 10));
        else if(num < 1000) // 789
            result.append(numberToWordsHelper(num / 100)).append(HUNDRED).append(numberToWordsHelper(num % 100));
        else if(num < 1000000) // 1000 - 99999
            result.append(numberToWordsHelper(num / 1000)).append(THOUSAND).append(numberToWordsHelper(num % 1000));
        else if(num < 1000000000) //
            result.append(numberToWordsHelper(num / 1000000)).append(MILLION).append(numberToWordsHelper(num % 1000000));
        else
            result.append(numberToWordsHelper(num / 1000000000)).append(BILLION).append(numberToWordsHelper(num % 1000000000));
        return result.toString().trim();
    }
}