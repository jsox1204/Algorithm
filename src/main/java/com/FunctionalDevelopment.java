package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class FunctionalDevelopment {
    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(solution(progresses, speeds)));

    }

    private static int[] solution(int[] progresses, int[] speeds) {

        Stack<Integer> integerStack = new Stack<>();
        ArrayList<Integer> days = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            days.add(i, (int) Math.ceil( (double) (100 - progresses[i]) / speeds[i]) );
        }

        ArrayList<Integer> forEachDistribution = new ArrayList<>();

        integerStack.push(0);

        for (int i = 1; i < days.size(); i++) {
            if (days.get(integerStack.peek()) < days.get(i)) {
                forEachDistribution.add(i - integerStack.peek());
                integerStack.push(i);
            }
        }

        if (!Objects.equals(days.get(integerStack.peek()), days.get(days.size() - 1))) {
            forEachDistribution.add(days.size() - integerStack.peek());
        } else {
            forEachDistribution.add(1);
        } // 각 배포마다 몇 개의 기능이 배포되는 지를 저장하는 배열의 마지막 요소 추가

        return forEachDistribution.stream().mapToInt(value -> value).toArray();
    }
}
