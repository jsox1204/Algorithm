package com;

import java.util.*;

public class NoSameNumber {
    public static void main(String[] args) {

        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        System.out.println(Arrays.toString(solution(arr)));
    }

    private static int[] solution(int[] arr) {

        List<Integer> answer = new ArrayList<>();

        Queue<Integer> integerQueue = new LinkedList<>();
        int checkNum = -1;

        for (int num : arr) {

            if (num != checkNum) {
                integerQueue.offer(num);
                checkNum = num;
            }

        }

        while (!(integerQueue.isEmpty())) {
            answer.add(integerQueue.poll());
        }


        return answer.stream().mapToInt(value -> value).toArray();
    }
}
