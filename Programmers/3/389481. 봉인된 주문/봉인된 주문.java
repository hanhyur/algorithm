import java.util.*;

class Solution {
    private String toBase26(long n, int len) {
        if (len == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        long current = n;
        for (int i = 0; i < len; i++) {
            sb.insert(0, (char) ('a' + current % 26));
            current /= 26;
        }
        return sb.toString();
    }

    private long countBannedSmallerOrEqual(String s, List<String> bannedList) {
        int low = 0;
        int high = bannedList.size() - 1;
        int count = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (bannedList.get(mid).compareTo(s) <= 0) {
                count = mid + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return count;
    }

    public String solution(long n, String[] bans) {
        Set<String> banSet = new HashSet<>(Arrays.asList(bans));
        Map<Integer, List<String>> bansByLength = new HashMap<>();
        for (String ban : bans) {
            bansByLength.computeIfAbsent(ban.length(), k -> new ArrayList<>()).add(ban);
        }
        for (List<String> list : bansByLength.values()) {
            Collections.sort(list);
        }

        long[] pow26 = new long[12];
        pow26[0] = 1;
        for (int i = 1; i <= 11; i++) {
            if (Long.MAX_VALUE / 26 < pow26[i - 1]) {
                 pow26[i] = Long.MAX_VALUE;
            } else {
                 pow26[i] = pow26[i - 1] * 26;
            }
        }

        int targetLength = 0;
        for (int len = 1; len <= 11; len++) {
            long totalInLen = pow26[len];
            long bannedInLen = bansByLength.getOrDefault(len, Collections.emptyList()).size();
            long validInLen = totalInLen - bannedInLen;

            if (n <= validInLen) {
                targetLength = len;
                break;
            }
            n -= validInLen;
        }

        List<String> relevantBans = bansByLength.getOrDefault(targetLength, Collections.emptyList());
        
        long low = n - 1;
        long high = n - 1 + relevantBans.size();
        long finalIdx = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (mid < 0 || (targetLength < 12 && mid >= pow26[targetLength])) {
                 high = mid - 1;
                 continue;
            }

            String midStr = toBase26(mid, targetLength);
            long bannedCount = countBannedSmallerOrEqual(midStr, relevantBans);
            long validRank = (mid + 1) - bannedCount;

            if (validRank < n) {
                low = mid + 1;
            } else {
                finalIdx = mid;
                high = mid - 1;
            }
        }
        
        while (banSet.contains(toBase26(finalIdx, targetLength))) {
            finalIdx++;
        }

        return toBase26(finalIdx, targetLength);
    }
}