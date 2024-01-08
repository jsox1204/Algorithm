package com;

import java.security.SecureRandom;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[] spaces = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        char computer = 'O';
        char player = 'X';

        drawBoard(spaces);

        while (true) {
            playerMove(spaces, player);
            drawBoard(spaces);

            if (checkWinner(spaces, player)) {
                break;
            } else if (checkTie(spaces)) {
                break;
            }

            computerMove(spaces, computer);
            drawBoard(spaces);

            if (checkWinner(spaces, player)) {
                break;
            } else if (checkTie(spaces)) {
                break;
            }
        }
    }

    /**
     * 틱택토 보드 그리기
     * @param spaces 보드의 현재 상황
     */
    private static void drawBoard(char[] spaces) {
        System.out.print('\n');
        System.out.println("     |     |     ");
        System.out.println("  " + spaces[0] + "  |  " + spaces[1] + "  |  " + spaces[2] + "  ");
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.println("  " + spaces[3] + "  |  " + spaces[4] + "  |  " + spaces[5] + "  ");
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.println("  " + spaces[6] + "  |  " + spaces[7] + "  |  " + spaces[8] + "  ");
        System.out.println("_____|_____|_____");
        System.out.print('\n');
    }

    /**
     * 플레이어가 보드에 표시하도록 한다.
     * @param spaces 보드의 현재 상황
     * @param player 플레이어의 표시 문자
     */
    private static void playerMove(char[] spaces, char player) {
        int number;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("표시할 위치를 입력하세요 (1~9): ");
            number = scanner.nextInt();

            number--;

            if (!(number >= 0 && number <= 8)) {
                continue;
            }

            if (spaces[number] == ' ') {
                spaces[number] = player;
            } else {
                System.out.println("비어있는 위치를 입력하세요!");
                number = 100;
            }
        } while (!(number >= 0 && number <= 8));
    }

    /**
     * 컴퓨터가 무작위로 보드에 표시한다.
     * @param spaces 보드의 현재 상황
     * @param computer 컴퓨터의 표시 문자
     */
    private static void computerMove(char[] spaces, char computer) {
        SecureRandom secureRandom = new SecureRandom();

        while (true) {
            int number = secureRandom.nextInt(9);
            if (spaces[number] == ' ') {
                spaces[number] = computer;
                break;
            }
        }
    }

    /**
     * 보드에 한 줄로 같은 표시가 있는지 확인하여 누가 이겼는지를 확인한다.
     * @param spaces 보드의 현재 상황
     * @param player 플레이어의 표시 문자
     * @return 승자의 존재 여부
     */
    private static boolean checkWinner(char[] spaces, char player) {
        String winLog;

        if ((spaces[0] != ' ') && (spaces[0] == spaces[1]) && (spaces[1] == spaces[2])) {
            winLog = (spaces[0] == player) ? "이겼습니다!" : "졌습니다!";
        } else if ((spaces[3] != ' ') && (spaces[3] == spaces[4]) && (spaces[4] == spaces[5])) {
            winLog = (spaces[3] == player) ? "이겼습니다!" : "졌습니다!";
        } else if ((spaces[6] != ' ') && (spaces[6] == spaces[7]) && (spaces[7] == spaces[8])) {
            winLog = (spaces[6] == player) ? "이겼습니다!" : "졌습니다!";
        } else if ((spaces[0] != ' ') && (spaces[0] == spaces[3]) && (spaces[3] == spaces[6])) {
            winLog = (spaces[0] == player) ? "이겼습니다!" : "졌습니다!";
        } else if ((spaces[1] != ' ') && (spaces[1] == spaces[4]) && (spaces[4] == spaces[7])) {
            winLog = (spaces[1] == player) ? "이겼습니다!" : "졌습니다!";
        } else if ((spaces[2] != ' ') && (spaces[2] == spaces[5]) && (spaces[5] == spaces[8])) {
            winLog = (spaces[2] == player) ? "이겼습니다!" : "졌습니다!";
        } else if ((spaces[0] != ' ') && (spaces[0] == spaces[4]) && (spaces[4] == spaces[8])) {
            winLog = (spaces[0] == player) ? "이겼습니다!" : "졌습니다!";
        } else if ((spaces[2] != ' ') && (spaces[2] == spaces[4]) && (spaces[4] == spaces[6])) {
            winLog = (spaces[2] == player) ? "이겼습니다!" : "졌습니다!";
        } else {
            return false;
        }

        System.out.println(winLog);
        return true;
    }

    /**
     * 보드의 표시가 꽉 찼는지 확인한다.
     * @param spaces 보드의 현재 상황
     * @return 보드가 완전히 찼는지에 대한 여부 (무승부)
     */
    private static boolean checkTie(char[] spaces) {
        for (int i = 0; i < 9; i++) {
            if (spaces[i] == ' ') {
                return false;
            }
        }

        System.out.println("무승부입니다!");
        return true;
    }
}
