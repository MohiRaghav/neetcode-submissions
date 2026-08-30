class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String s : strs){
            str.append(s.length()).append('#').append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int sepIndx = str.indexOf('#', i);

            int len = Integer.parseInt(str.substring(i, sepIndx));

            i = sepIndx + 1;

            String decodedString = str.substring(i, i+len);

            decodedStrings.add(decodedString);

            i = i + len;
        }
        return decodedStrings;
    }
}
