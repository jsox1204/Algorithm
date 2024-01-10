package com;

import java.util.*;

public class ListOfPhoneNumbers {
    public static void main(String[] args) {

        String[] phoneBook = {"123","456","789"};

        System.out.println(solution(phoneBook));
    }

    private static boolean solution(String[] phoneBook) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }

        for (String string : phoneBook) {
            for (int j = 0; j < string.length(); j++) {
                if (map.containsKey(string.substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
