class Solution {
    public List<String> fizzBuzz(int n) {
        final String Fizz = "Fizz", Buzz = "Buzz", FizzBuzz = "FizzBuzz";
        List<String> answer = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i%3 == 0 && i%5 == 0) {
                answer.add(FizzBuzz);
            } else if(i % 5 == 0) {
                answer.add(Buzz);
            } else if(i % 3 == 0) {
                answer.add(Fizz);
            } else answer.add(String.valueOf(i));
        }
        return answer;
    }
}