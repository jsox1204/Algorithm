package com;

import java.util.*;

public class Process {
    public static void main(String[] args) {

        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }

    private static int solution(int[] priorities, int location) {

        Queue<Integer> integerQueue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            integerQueue.offer(i);
            priorityQueue.offer(priorities[i]);
        }

        while (!integerQueue.isEmpty()) {

            int process = integerQueue.poll();

            if (priorityQueue.isEmpty()) {
                return 0;
            } // priorityQueue.peek() nullPointerException 방지

            if (priorities[process] == priorityQueue.peek()) {
                priorityQueue.poll();
                answer++;
                if (process == location) {
                    return answer;
                }
            } else {
                integerQueue.offer(process);
            }
        }

        return 0;
    }
}
