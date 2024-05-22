class Solution {
    /**
     * 중복되지 않는 부분 문자열의 최대 길이를 구한다.
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int start = 0, end = 0, max = 0;

        // end 포인터를 이동시키면서 탐색
        while (end < s.length()) {
            // 해당 문자가 맵에 존재하는지 확인
            // getOrDefault : key가 있으면 value, 없으면 default 반환
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);

            // 새로운 key value가 추가되면 max 갱신
            if (map.size() == end - start + 1) {
                max = Math.max(max, end - start + 1);
                end++;
            } else if (map.size() < end - start + 1) {
                // 중복된 값이 없을 때까지 start 포인터를 이동
                while (map.size() < end - start + 1) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);

                    if(map.get(s.charAt(start)) == 0) {
                        map.remove(s.charAt(start));
                    }

                    start++;
                }

                end++;
            }
        }

        return max;
    }
}