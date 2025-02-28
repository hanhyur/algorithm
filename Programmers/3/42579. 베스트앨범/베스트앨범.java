import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playMap = new HashMap<>();
        Map<String, List<int[]>> genreMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            playMap.put(genre, playMap.getOrDefault(genre, 0) + play);
            genreMap.computeIfAbsent(genre, k -> new ArrayList<>())
                .add(new int[]{i, play});
        }
        
        List<String> sortedGenres = playMap.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .map(Map.Entry::getKey)
            .collect(toList());
        
        List<Integer> result = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            List<Integer> songs = genreMap.get(genre).stream()
                .sorted((a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0])
                .limit(2)
                .map(song -> song[0])
                .collect(toList());
            
            result.addAll(songs);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}