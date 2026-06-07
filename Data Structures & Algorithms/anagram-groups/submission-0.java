class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Set<String> calculated = new HashSet<>();
        for(String s: strs){
            if(calculated.contains(s))
                continue;
            List<String> anagrams = anagramList(s, strs);
            result.add(anagrams);
            for(String anagram: anagrams)
                calculated.add(anagram);
        }
        return result;
    }

    private List<String> anagramList(String source, String[] strs){
        //System.out.println("======");
        //System.out.println("anagramList:Source::"+ source);
        List<String> anagrams = new ArrayList<>();
        
        for(String targetString: strs){
            Map<Character, Integer> om = buildOccurenceMap(source);
            //System.out.println("Source::" + source + " om::" + om +" targetString::" + targetString);
            if(targetString.length() != source.length()){
                //System.out.println("Source::" + source +" targetString::" + targetString + " Length doesn't match");
                continue;
            }

            boolean found = true;
            for( int i=0; i< targetString.length(); i++){
                Character c = targetString.charAt(i);
                if(!om.containsKey(c) || om.get(c) - 1 <0){
                    found = false;
                    break;
                }
                om.put(c, om.get(c) - 1);
            }

            if(found){
                //System.out.println("Source::" + source + " om::" + om + " targetString:: " + targetString + " Found");
                anagrams.add(targetString);
            }
        }
        //System.out.println(anagrams);
        //System.out.println("======");
        return anagrams;

    }

    private Map<Character, Integer> buildOccurenceMap(String source){
        Map<Character, Integer> om = new HashMap<>();
        for(int i=0; i<source.length(); i++){
            if(om.containsKey(source.charAt(i))){
                om.put(source.charAt(i), om.get(source.charAt(i)) + 1);
            }else{
                om.put(source.charAt(i), 1);
            }
        }
        return om;
    }
}
