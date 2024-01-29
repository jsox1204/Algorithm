package com;

import java.util.Arrays;
import java.util.Stack;

public class StockPrice {
    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solution(prices)));
    }

    private static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        Stack<Integer> time = new Stack<>();

        for (int i = 0; i < prices.length; i++){
            while (!time.isEmpty() && prices[i] < prices[time.peek()]){
                answer[time.peek()] = i - time.peek();
                time.pop();
            }
            time.push(i);
        }

        while (!time.isEmpty()){
            answer[time.peek()] = prices.length - time.peek() - 1;
            time.pop();
        }
        return answer;
    }
}
