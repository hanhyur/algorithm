class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sortStr = new String(chars);

            if (!map.containsKey(sortStr)) {
                map.put(sortStr, new ArrayList<>());
            } 

            map.get(sortStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}