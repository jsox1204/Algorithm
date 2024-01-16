package com;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    private static int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> totalPlaysGenres = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            totalPlaysGenres.put(genres[i], totalPlaysGenres.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> sortGenreByPlays = new ArrayList<>(totalPlaysGenres.keySet()); // 장르를 플레이수를 기준으로 오름차순으로 정렬하기 위해 변수 추가

        sortGenreByPlays.sort((o1, o2) -> totalPlaysGenres.get(o2).compareTo(totalPlaysGenres.get(o1))); // 장르를 플레이수를 기준으로 오름차순으로 정렬

        Map<Integer, Integer> indexPlays = new HashMap<>(); // 각 장르에서 내림차순으로 정렬하기 위한 map

        List<Integer> answerList = new ArrayList<>(); // indexPlays map을 value를 기준으로 내림차순을 할 때 key를 저장하기 위한 list

        for (String sortGenreByPlay : sortGenreByPlays) {
            for (int j = 0; j < genres.length; j++) {
                if (Objects.equals(sortGenreByPlay, genres[j])) {
                    indexPlays.put(j, plays[j]);
                }
            }

            List<Integer> indexKeys = new ArrayList<>(indexPlays.keySet());

            indexKeys.sort((o1, o2) -> indexPlays.get(o2).compareTo(indexPlays.get(o1)));


            if (indexKeys.size() < 2) {
                answerList.addAll(indexKeys.subList(0, 1));
            } else {
                answerList.addAll(indexKeys.subList(0, 2));
            }


            indexPlays.clear();
        }


        return answerList.stream().mapToInt(value -> value).toArray();
    }
}
