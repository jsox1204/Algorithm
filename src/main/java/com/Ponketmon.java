package com;

import java.util.HashSet;
import java.util.Set;

public class Ponketmon {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
    }

    /**
     * 여러 마리의 폰켓몬 중에서 반만 가져갈 때 최대로 가져갈 수 있는 폰켓몬의 종류를 구하는 메서드
     * @param nums 폰켓몬의 종류 번호가 담긴 1차원 배열 (배열의 길이는 항상 짝수)
     * @return 가장 많은 종류의 폰켓몬을 선택할 떄 폰켓몬 종류 번호의 개수 (배열의 길이가 짝수가 아니면 0을 반환)
     */
    public static int solution(int[] nums) {
        int answer = 0;

        if (nums.length % 2 == 1) {
            return answer;
        }

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int setSize = set.size();
        int numsDiv2 = nums.length / 2;

        answer = Math.min(setSize, numsDiv2);

        return answer;
    }
}
