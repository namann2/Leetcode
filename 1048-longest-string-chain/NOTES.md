### Solution 1 :

Scope of improvement : 
1. Better way to verify if one word is a predecessor of another
2. TC : O(nlogn + n * n * L), where L is the average length of word
3. SC : O(n)

```
class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        // sort the words by length
        Arrays.sort(words, (w1, w2) -> {
            return w1.length() - w2.length();
        });
        
        // this seems like an application of LIS
        int[] dp = new int[n + 1];
        int maxLength = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(isPredecessor(words[j], words[i]) && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
            
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
    
    private boolean isPredecessor(String A, String B) {
        // check if word A is predecessor of word B
        int differ = 0;
        int n = A.length(), m = B.length(), i = 0, j = 0;
        if(m - n != 1) return false;
        while(i < n && j < m) {
            char a = A.charAt(i);
            char b = B.charAt(j);
            if(a == b) {
                i ++;
                j ++;
            } else {
                j++;
                differ ++;
            }
        }
        return differ <= 1; // less than one because
        // there are two options : ab, abc and ab, dab
        // ab, abc has differ 0 but we know that their length differ by 1
    }
}
```

### Solution 2 :
Improved version of above solution : 
1. From particular string, remove all jth char and find LIS ending at that string
2. TC : O(n logn + n * L)
3. SC : O(n)

```
class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        // sort the words by length
        Arrays.sort(words, (w1, w2) -> {
            return w1.length() - w2.length();
        });
        
        // this seems like an application of LIS
        Map<String, Integer> wordLIS = new HashMap<>();
        wordLIS.put(words[0], 1);
        
        int maxLength = 1;
        
        for(int i = 1; i < n; i++) {
            String currWord = words[i];
            int wordLength = currWord.length();
            int currLIS = 1;
            for(int j = 0; j < wordLength; j++) {
                String newStr = new StringBuilder(currWord).deleteCharAt(j).toString();
                if(wordLIS.containsKey(newStr)) {
                    currLIS = Math.max(currLIS, 1 + wordLIS.get(newStr));
                }
            }
            wordLIS.put(currWord, currLIS);
            maxLength = Math.max(maxLength, currLIS);
        }
        
        return maxLength;
    }
}
```
