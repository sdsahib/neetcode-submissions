class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> occurenceMap = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            if(!occurenceMap.containsKey(s.charAt(i))){
                occurenceMap.put(s.charAt(i), 1);
            }else{
                occurenceMap.put(s.charAt(i), occurenceMap.get(s.charAt(i)) + 1);
            }
        }

        //System.out.println(occurenceMap);
        for(int i=0;i<t.length();i++){
            if(!occurenceMap.containsKey(t.charAt(i)) ){
                return false;
            } else{
                if(occurenceMap.get(t.charAt(i)) - 1  < 0){
                    return false;
                }
                occurenceMap.put(t.charAt(i),occurenceMap.get(t.charAt(i)) -1);
            }
            //System.out.println(t.charAt(i)+ "::" +occurenceMap);
        }

        return true;
    }
}
