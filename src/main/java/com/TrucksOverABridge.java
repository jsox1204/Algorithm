package com;

import java.util.LinkedList;
import java.util.Queue;

public class TrucksOverABridge {
    public static void main(String[] args) {
        int bridgeLength = 100;
        int weight = 100;
        int[] truckWeights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridgeLength, weight, truckWeights));
    }

    private static int solution(int bridgeLength, int weight, int[] truckWeights) {

        Queue<Integer> bridge = new LinkedList<>(); // 다리에 있는 트럭
        Queue<Integer> timeTrucksEnteredTheBridge = new LinkedList<>(); // 다리에 트럭이 들어간 시간
        Queue<Integer> waitingTrucks = new LinkedList<>(); // 대기 중인 트럭

        int answer = 0;
        int totalWeight = 0; // 현재 다리에 있는 트럭의 총무게

        for (int i : truckWeights) {
            waitingTrucks.offer(i);
        }

        do {

            answer++;

            if (!timeTrucksEnteredTheBridge.isEmpty() && answer == timeTrucksEnteredTheBridge.peek() + bridgeLength) {
                timeTrucksEnteredTheBridge.poll();
                totalWeight -= (bridge.peek() != null) ? bridge.peek() : 0;
                bridge.poll();
            } // 다리를 다 건너간 트럭 계산

            if (!waitingTrucks.isEmpty() && weight >= totalWeight + waitingTrucks.peek()) {
                totalWeight += (waitingTrucks.peek() != null) ? waitingTrucks.peek() : 0;
                bridge.offer(waitingTrucks.poll());
                timeTrucksEnteredTheBridge.offer(answer);
            } // 다리에 들어가는 트럭 계산

        } while (!(waitingTrucks.isEmpty() && bridge.isEmpty()));

        return answer;
    }
}
