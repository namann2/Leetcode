else if(ch == 'P') cnt[1]++;
else cnt[2]++;
}
int pickTime = cnt[0] + cnt[1] + cnt[2];
int travelTime = 0;
if(i > 0) {
travelTime =  cnt[0] > 0 ? (pM == -1 ? R[i] : R[i] - R[pM]) : 0;
travelTime +=  (cnt[1] > 0 ? (pP == -1 ? R[i] : R[i] - R[pP]) : 0);
travelTime +=  (cnt[2] > 0 ? (pG == -1 ? R[i] : R[i] - R[pG]) : 0);
}
int curr = travelTime + pickTime;
result += curr;
for(char ch : s.toCharArray()) {
if(ch == 'M') pM = i;
if(ch == 'P') pP = i;
if(ch == 'G') pG = i;
}
}
return result;
}
}
```