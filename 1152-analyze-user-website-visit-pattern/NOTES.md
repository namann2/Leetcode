# Solution  : 

```
class Pair {
    int timestamp;
    String website;
    Pair(int timestamp, String website) {
        this.timestamp = timestamp;
        this.website = website;
    }
}
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, ArrayList<Pair>> userWebsitePattern = new HashMap<>();
        int total = website.length;
        // mapping of user -> list of website he has visited
        for(int i=0;i<total;i++) {
            String user = username[i];
            int time = timestamp[i];
            String web = website[i];
            
            userWebsitePattern.putIfAbsent(user, new ArrayList<>());
            userWebsitePattern.get(user).add(new Pair(time, web));
            
            ArrayList<Pair> l = userWebsitePattern.get(user);
            Collections.sort(l, (up1, up2)->{
                return up1.timestamp - up2.timestamp;
            });
            
            userWebsitePattern.put(user, l);
        }
        
        // mapping of website -> users
        HashMap<String, HashSet<String>> websiteUserPattern = new HashMap<>();
        for(String user : userWebsitePattern.keySet()) {
            ArrayList<Pair> curr = userWebsitePattern.get(user);
            int n = curr.size();
            for(int i=0;i<n;i++) {
                for(int j=i+1;j<n;j++) {
                    for(int k=j+1;k<n;k++) {
                        String webPattern = curr.get(i).website+","+
                                            curr.get(j).website+","+
                                            curr.get(k).website;
                        
                        websiteUserPattern.putIfAbsent(webPattern, new HashSet<>());
                        websiteUserPattern.get(webPattern).add(user);
                    }
                }
            }
        }
        
        // find the pattern with largest score
        int score = -1;
        String websiteWithMaxScore = null;
        for(String web : websiteUserPattern.keySet()) {
            HashSet<String> users = websiteUserPattern.get(web);
            if(users.size() == score && web.compareTo(websiteWithMaxScore) <= -1) 
                websiteWithMaxScore = web;
            else if(users.size() > score) {
                score = users.size();
                websiteWithMaxScore = web;
            }
        }
        
        List<String> result = new ArrayList<>();
        String[] data = websiteWithMaxScore.split(",");
        for(String web : data) result.add(web);
        return result;
    }
}
```
