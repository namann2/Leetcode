class Pair {
    String website;
    int timestamp;
    Pair(String website, int timestamp) {
        this.website = website;
        this.timestamp = timestamp;
    }
}
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] websites) {
        Map<String, List<Pair>> userWebsitePattern = new HashMap<>();
        int n = timestamp.length;
        
        for(int i=0;i<n;i++) {
            String user = username[i];
            String website = websites[i];
            int time = timestamp[i];
            
            userWebsitePattern.putIfAbsent(user, new ArrayList<>());
            userWebsitePattern.get(user).add(new Pair(website, time));
        }
        
        Map<String, Set<String>> websiteVisitPattern = new HashMap<>();
        
        for(String user : userWebsitePattern.keySet()) {
            
            List<Pair> curr = userWebsitePattern.get(user);
            
            Collections.sort(curr, (p1, p2)->{
                return p1.timestamp - p2.timestamp;
            });
            
            int size = curr.size();
            for(int i=0;i<size;i++) {
                for(int j=i+1;j<size;j++) {
                    for(int k=j+1;k<size;k++) {
                        StringBuilder pattern = new StringBuilder();
                        String one = curr.get(i).website,
                               two = curr.get(j).website,
                               three = curr.get(k).website;
                        
                        pattern.append(one).append("-").append(two).append("-").append(three);
                        String pattern_string = pattern.toString();
                        
                        websiteVisitPattern.putIfAbsent(pattern_string, new HashSet<>());
                        websiteVisitPattern.get(pattern_string).add(user);
                    }
                }
            }
        }
        
        int maxScore = -1;
        String websiteWithMaxScore = null;
        
        for(String website : websiteVisitPattern.keySet()) {
            
            int curr_visit_cnt = websiteVisitPattern.get(website).size();
            
            if(curr_visit_cnt > maxScore) {
                maxScore = curr_visit_cnt;
                websiteWithMaxScore = website;
            }
            else if(curr_visit_cnt == maxScore && website.compareTo(websiteWithMaxScore) <= -1) {
                websiteWithMaxScore = website;
            }
        }
        
        List<String> result = new ArrayList<>();
        for(String curr : websiteWithMaxScore.split("-"))
            result.add(curr);
        
        return result;
    }
}