package com;

import java.util.ArrayList;
import java.util.List;

public class MinRectangle {
    public static void main(String[] args) {
        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        List<Integer> widths = new ArrayList<>(); // 명함 너비 배열
        List<Integer> heights = new ArrayList<>(); // 명함 높이 배열

        for (int[] size : sizes) { // 명함의 너비와 높이를 배열에 추가
            widths.add(size[0]);
            heights.add(size[1]);
        }

        // 명함의 너비와 높이의 최대값 구하기
        int widthMax = widths.stream().max(Integer::compare).orElse(0);
        int heightMax = heights.stream().max(Integer::compare).orElse(0);

        // 명함 중에 높이가 최대값인 명함의 너비가 높이보다 짧으면 명함을 눕힌 후(너비와 높이를 서로 바꾼다.) 최대값 다시 계산
        while (widths.get(heights.indexOf(heightMax)) < heightMax) {
            int temp = widths.get(heights.indexOf(heightMax));
            widths.set(heights.indexOf(heightMax), heights.get(heights.indexOf(heightMax)));
            heights.set(heights.indexOf(heightMax), temp);

            widthMax = widths.stream().max(Integer::compare).orElse(0);
            heightMax = heights.stream().max(Integer::compare).orElse(0);
        }

        return widthMax * heightMax;
    }
}
