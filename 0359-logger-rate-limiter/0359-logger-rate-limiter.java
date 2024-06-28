class Logger {

    private Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        Iterator<String> it = map.keySet().iterator(); 
        while(it.hasNext()) {
            String key = it.next();
            if(timestamp - 10 > map.get(key)) it.remove();
        }
        
        if(!map.containsKey(message) || (map.get(message) <= timestamp)) {
            map.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}
