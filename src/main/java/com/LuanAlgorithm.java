package com;

import java.util.Scanner;

public class LuanAlgorithm {
    public static void main(String[] args) {

        String cardNumber;
        int result; // 카드 번호를 룬 알고리즘으로 계산하기 위한 변수
        Scanner scanner = new Scanner(System.in);

        System.out.println("카드번호를 입력하세요: ");
        cardNumber = scanner.nextLine();

        cardNumber = cardNumber.replaceAll(" ", "");

        result = sumEvenDigits(cardNumber) + sumOddDigits(cardNumber);

        if (result % 10 == 0) {
            System.out.println("카드번호가 유효합니다.");
        } else {
            System.out.println("카드번호가 유효하지 않습니다.");
        }

    }

    /**
     * 한 자리 숫자이면 그대로 반환하고 두 자리 숫자 이면 각 자리의 수를 합한다.
     * @param number 계산할 숫자
     * @return 계산한 값
     */
    public static int getDigit(int number) {
        return number % 10 + (number / 10 % 10);
    }

    /**
     * 카드번호 오른쪽부터 홀수번째의 숫자를 더한다.
     * @param cardNumber 카드번호
     * @return 홀수번째의 숫자를 모두 더한 값
     */
    public static int sumOddDigits(String cardNumber) {
        int sum = 0;

        for (int i = cardNumber.length() - 1; i >= 0; i -= 2) {
            sum += cardNumber.charAt(i) - '0';
        }

        return sum;
    }

    /**
     * 카드번호 오른쪽부터 짝수번째의 숫자를 2배로 하여 더한다 2배로 한 값이 10이상 이면 각 자릿수를 더한다.
     * @param cardNumber 카드번호
     * @return 더하여 계산한 결과값
     */
    public static int sumEvenDigits(String cardNumber) {
        int sum = 0;

        for (int i = cardNumber.length() - 2; i >= 0; i -= 2) {
            sum += getDigit((cardNumber.charAt(i) - '0') * 2);
        }

        return sum;
    }
}
