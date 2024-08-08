package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeExam {
    public static void main(String[] args) {
        int[] answer = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answer)));
    }

    public static int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>(); // 반환할 값
        int[][] students = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}}; // 학생이 찍는 답을 찍는 방식

        List<Integer> scores = new ArrayList<>(); // 학생들의 점수

        for (int[] ignored : students) { // 학생의 수에 따라 점수 배열 초기화
            scores.add(0);
        }

        for (int i = 0; i < answers.length; i++) { // 학생이 찍은 답을 순회하면서 답이 맞는지 확인 후 점수 증가
            int studentAnswer = answers[i];

            for (int j = 0; j < students.length; j++) {
                if (students[j][i % students[j].length] == studentAnswer) {
                    scores.set(j, scores.get(j) + 1);
                }
            }
        }

        int scoreMax = scores.stream().max(Integer::compareTo).orElse(0); // 가장 높은 점수

        // 가장 높은 점수가 여러 명인지 확인
        int scoreIndex = 1;
        for (int score: scores) {
            if (score == scoreMax) {
                answer.add(scoreIndex);
            }
            scoreIndex++;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
