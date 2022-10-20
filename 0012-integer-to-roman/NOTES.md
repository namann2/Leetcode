if(num >= 900)
return answer.append("CM").append(intToRoman(num - 900)).toString();
if(num >= 500)
return answer.append("D").append(intToRoman(num - 500)).toString();
if(num >= 400)
return answer.append("CD").append(intToRoman(num - 400)).toString();
if(num >= 100)
return answer.append("C").append(intToRoman(num - 100)).toString();
if(num >= 90)
return answer.append("XC").append(intToRoman(num - 90)).toString();
if(num >= 50)
return answer.append("L").append(intToRoman(num - 50)).toString();
if(num >= 40)
return answer.append("XL").append(intToRoman(num - 40)).toString();
if(num >= 10)
return answer.append("X").append(intToRoman(num - 10)).toString();
if(num >= 9)
return answer.append("IX").append(intToRoman(num - 9)).toString();
if(num >= 5)
return answer.append("V").append(intToRoman(num - 5)).toString();
if(num >= 4)
return answer.append("IV").append(intToRoman(num - 4)).toString();
if(num >= 1)
return answer.append("I").append(intToRoman(num - 1)).toString();
return answer.toString();
}
}
StringBuilder op = new StringBuilder();
```