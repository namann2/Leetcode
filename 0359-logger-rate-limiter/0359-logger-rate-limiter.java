class Logger {
    private ConcurrentHashMap<String, Integer> map;
    public Logger() {
        map = new ConcurrentHashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        for(String msg : map.keySet())
            if(map.get(msg) <= timestamp - 11)
                map.remove(msg);
        
        if(!map.containsKey(message) || timestamp >= map.get(message)) {
            map.put(message, timestamp + 10);
            return true;
        } 
        return false;
    }
}
