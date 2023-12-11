package com;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class AthletesWhoDidntFinish {
    public static void main(String[] args) {

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant, completion));

    }

    /**
     * 마라톤에 참여한 선수 중에서 완주하지 못한 선수를 찾는 함수 (완주하지 못한 선수는 1명)
     * @param participant 마라톤에 참여한 선수들의 이름이 담긴 배열
     * @param completion 완주한 선수들의 이름이 담긴 배열
     * @return 완주하지 못한 선수의 이름
     */
    public static String solution(String[] participant, String[] completion) {

        AtomicReference<String> answer = new AtomicReference<>("");

        Map<String, Integer> map = new HashMap<>();

        // 경기에 참여한 선수의 수 입력
        for (String athlete : participant) {
            map.put(athlete, map.getOrDefault(athlete, 0) + 1);
        }

        // 완주한 선수의 수만큼 빼기
        for (String athlete : completion) {
            map.put(athlete, map.get(athlete) - 1);
        }

        // 람다 표현식에 사용되는 변수는 final 또는 유사 final
        map.forEach((athlete, integer) -> {
            if (integer >= 1) answer.set(athlete);
        });

        return answer.toString();
    }
}
