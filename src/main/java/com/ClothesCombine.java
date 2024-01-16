package com;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ClothesCombine {
    public static void main(String[] args) {

        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    private static int solution(String[][] clothes) {

        AtomicInteger answer = new AtomicInteger(1);

        if (clothes.length == 0) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        map.forEach((string, integer) -> answer.updateAndGet(v -> (v * (integer + 1)) ));
        answer.updateAndGet(v -> v - 1);

        return answer.get();
    }
}
